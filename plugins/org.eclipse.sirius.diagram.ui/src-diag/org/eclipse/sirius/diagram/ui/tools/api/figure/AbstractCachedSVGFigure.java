/*******************************************************************************
 * Copyright (c) 2007, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.diagram.ui.tools.api.figure;

import java.awt.image.BufferedImage;
import java.util.Collection;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
import org.eclipse.sirius.diagram.ui.tools.internal.figure.TransparentFigureGraphicsModifier;
import org.eclipse.sirius.diagram.ui.tools.internal.figure.svg.ImageCache;
import org.eclipse.sirius.diagram.ui.tools.internal.figure.svg.SVGUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Document;

import com.google.common.collect.Lists;

/**
 * A {@link AbstractCachedSVGFigure} is a {@link SVGFigure} corresponding to a
 * svg image. {@link Image} are store in a map with soft values.
 *
 * @author mporhel
 */
public abstract class AbstractCachedSVGFigure extends SVGFigure {
    /**
     * Cache to store bitmaps of rendered SVGs.
     */
    private static final ImageCache CACHE = new ImageCache();

    @Override
    protected void paintFigure(Graphics graphics) {
        TransparentFigureGraphicsModifier modifier = new TransparentFigureGraphicsModifier(this, graphics);
        modifier.pushState();

        Rectangle r = getClientArea();
        Image image = getCachedImage(getKey() + getContextKey(graphics), r, graphics);
        // Draw the image
        if (image != null) {
            graphics.drawImage(image, r.x, r.y);
        }
        modifier.popState();
    }

    private String getContextKey(Graphics graphics) {
        // CHECKSTYLE:OFF
        int aaText = SWT.DEFAULT;
        try {
            aaText = graphics.getTextAntialias();
        } catch (Exception e) {
            // not supported
        }
        // CHECKSTYLE:ON

        StringBuilder result = new StringBuilder();
        result.append(aaText);
        result.append(AbstractCachedSVGFigure.SEPARATOR);
        Rectangle r = getClientArea();
        result.append(r.width);
        result.append(AbstractCachedSVGFigure.SEPARATOR);
        result.append(r.height);

        return result.toString();
    }

    /**
     * Get the image cached or create new one and cache it.
     *
     * @param key
     *            the key
     * @param clientArea
     *            the client area
     * @param graphics
     *            the graphical context
     * @return an image store in a cache
     */
    protected Image getCachedImage(final String key, Rectangle clientArea, Graphics graphics) {
        Image result = AbstractCachedSVGFigure.CACHE.getIfPresent(key);
        if (result == null) {
            /* Create the image if it does not exist */
            Document document = getDocument();
            if (document == null) {
                return null;
            }
            getTranscoder().setCanvasSize(clientArea.width, clientArea.height);
            updateRenderingHints(graphics);
            BufferedImage awtImage = getTranscoder().getBufferedImage();
            if (awtImage != null) {
                result = SVGUtils.toSWT(Display.getCurrent(), awtImage);
                AbstractCachedSVGFigure.CACHE.put(key, result);
            }
        }
        // Get the image from the cache
        return result;
    }

    /**
     * Compute a key for this figure. This key is used to store in cache the
     * corresponding {@link org.eclipse.swt.graphics.Image}.
     *
     * The key must begin by the document key.
     *
     * @return The key corresponding to this BundleImageFigure.
     */
    protected abstract String getKey();

    /**
     * Remove all entries whose key begins with the given key. Remove from the
     * document map, the entries with the given keys to force to re-read the
     * file.
     *
     * @param documentKey
     *            the document key.
     * @return true of something was removed.
     */
    protected static boolean doRemoveFromCache(final String documentKey) {
        if (!StringUtil.isEmpty(documentKey)) {
            boolean remove = false;
            Collection<String> keyToRemove = Lists.newArrayList();
            for (String key : AbstractCachedSVGFigure.CACHE.keySet()) {
                if (key.startsWith(documentKey)) {
                    keyToRemove.add(key);
                }
            }

            for (String toRemove : keyToRemove) {
                AbstractCachedSVGFigure.CACHE.invalidate(toRemove);
                remove = true;
            }
            boolean removedFromDocumentsMap = SVGFigure.documentsMap.remove(documentKey) != null;
            return remove || removedFromDocumentsMap;
        }
        return false;
    }

}
