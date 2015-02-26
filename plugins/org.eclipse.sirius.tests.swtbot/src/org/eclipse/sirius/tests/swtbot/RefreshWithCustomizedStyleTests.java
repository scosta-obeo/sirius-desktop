/*******************************************************************************
 * Copyright (c) 2010, 2014 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tests.swtbot;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.ui.business.api.query.ViewQuery;
import org.eclipse.sirius.diagram.ui.business.internal.query.CustomizableQuery;
import org.eclipse.sirius.diagram.ui.internal.refresh.diagram.ViewPropertiesSynchronizer;
import org.eclipse.sirius.tests.support.api.TestsUtil;
import org.eclipse.sirius.viewpoint.FontFormat;
import org.eclipse.sirius.viewpoint.Style;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * Test the style customization features.
 * 
 * See VP-3535.
 * 
 * @author <a href="mailto:esteban.dugueperoux@obeo.fr">Esteban Dugueperoux</a>
 */
public class RefreshWithCustomizedStyleTests extends AbstractRefreshWithCustomizedStyleOnCompleteExampleTest {

    /**
     * Test all GMF Note features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testGMFNoteStyleCustomization() throws Exception {
        testStyleCustomization(noteEditPartBot);
    }

    /**
     * Test all GMF NoteAttachment features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testGMFNoteAttachmentStyleCustomization() throws Exception {
        testStyleCustomization(noteAttachmentEditPartBot);
    }

    /**
     * Test all GMF Text features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testGMFTextStyleCustomization() throws Exception {
        testStyleCustomization(textEditPartBot);
    }

    /**
     * Test set a workspace image style on all node.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testSetWorkspaceImageStyleCustomization() throws Exception {
        // Not available in 4.x specific Tabbar
        if (TestsUtil.isDynamicTabbar()) {
            return;
        }

        editor.reveal(eClass1WithSquareStyleBot.part());
        eClass1WithSquareStyleBot.select();
        AbstractSWTBot<? extends Widget> setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        AbstractSWTBot<? extends Widget> resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, false);
        AbstractSWTBot<? extends Widget> setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        AbstractSWTBot<? extends Widget> resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, false);

        // Set a workspace image
        click(setStyleToWorkspaceImageButtonFromAppearanceTab);
        SWTBotShell activeShell = bot.activeShell();
        SWTBot workspaceImageSelectionDialogBot = activeShell.bot();
        workspaceImageSelectionDialogBot.text().setText(getProjectName() + "/" + NEW_IMAGE_NAME);
        workspaceImageSelectionDialogBot.button("OK").click();
        bot.waitUntil(Conditions.shellCloses(activeShell));

        // Test the buttons states
        checkFigure(eClass1WithSquareStyleBot, DiagramPackage.Literals.WORKSPACE_IMAGE__WORKSPACE_PATH);
        editor.show();

        setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, true);
        setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, true);

        // Test that a refresh doesn't remove the
        selectAndRefreshDiagram();

        checkFigure(eClass1WithSquareStyleBot, DiagramPackage.Literals.WORKSPACE_IMAGE__WORKSPACE_PATH);
        editor.reveal(eClass1WithSquareStyleBot.part());
        eClass1WithSquareStyleBot.select();

        setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, true);
        setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, true);

        // Cancel the style customization (workspace image)
        editor.show();
        eClass1WithSquareStyleBot.select();
        click(resetStylePropertiesToDefaultValuesButtonFromAppearanceTab);
        editor.show();
        eClass1WithSquareStyleBot.select();

        setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, false);
        setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, false);

        // Set a workspace image
        click(setStyleToWorkspaceImageButtonFromTabbar);
        activeShell = bot.activeShell();
        workspaceImageSelectionDialogBot = activeShell.bot();
        workspaceImageSelectionDialogBot.text().setText(getProjectName() + "/" + NEW_IMAGE_NAME);
        workspaceImageSelectionDialogBot.button("OK").click();
        bot.waitUntil(Conditions.shellCloses(activeShell));

        // Test the buttons states
        checkFigure(eClass1WithSquareStyleBot, DiagramPackage.Literals.WORKSPACE_IMAGE__WORKSPACE_PATH);
        editor.show();

        setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, true);
        setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, true);

        // Test that a refresh doesn't remove the
        selectAndRefreshDiagram();

        checkFigure(eClass1WithSquareStyleBot, DiagramPackage.Literals.WORKSPACE_IMAGE__WORKSPACE_PATH);

        editor.show();
        eClass1WithSquareStyleBot.select();

        setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, true);
        setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, true);

        // Cancel the style customization (workspace image)
        click(resetStylePropertiesToDefaultValuesButtonFromTabbar);

        setStyleToWorkspaceImageButtonFromTabbar = getSetStyleToWorkspaceImageButton(true, true);
        resetStylePropertiesToDefaultValuesButtonFromTabbar = getResetStylePropertiesToDefaultValuesButton(true, false);
        setStyleToWorkspaceImageButtonFromAppearanceTab = getSetStyleToWorkspaceImageButton(false, true);
        resetStylePropertiesToDefaultValuesButtonFromAppearanceTab = getResetStylePropertiesToDefaultValuesButton(false, false);

    }

    /**
     * Test all square style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testSquareStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithSquareStyleBot);
    }

    /**
     * Test all lozenge style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testLozengeStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithLozengeStyleBot);
    }

    /**
     * Test all ellipse style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testEllipseStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithEllipseStyleBot);
    }

    /**
     * Test all bundled image style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testBundledImageStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithBundledImageStyleBot);
    }

    /**
     * Test all note style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testSiriusNoteStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithNoteStyleBot);
    }

    /**
     * Test all dot style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testDotStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithDotStyleBot);
    }

    /**
     * Test all gauge composite style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testGaugeCompositeStyleCustomization() throws Exception {
        testStyleCustomization(eClass1WithGaugeStyleBot);
    }

    /**
     * Test all workspace image style features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testWorkspaceImageStyleOnNodeCustomization() throws Exception {
        testStyleCustomization(eClass1WithWorkspaceImageStyleBot);
    }

    /**
     * Test all flatContainerStyle features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testFlatContainerStyleCustomization() throws Exception {
        testStyleCustomization(package1WithFlatContainerStyleBot);
    }

    /**
     * Test all shapeContainerStyle features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testShapeContainerStyleCustomization() throws Exception {
        testStyleCustomization(package1WithShapeContainerStyleBot);
    }

    /**
     * Test all workspaceImageStyle features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testWorkspaceImageStyleOnContainerCustomization() throws Exception {
        testStyleCustomization(package1WithWorkspaceImageStyleBot);
    }

    /**
     * Test all edgeStyle features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testEdgeStyleCustomization() throws Exception {
        testStyleCustomization(referenceEditPartBot);
    }

    /**
     * Test all bracketEdgeStyle features customization.
     * 
     * @throws Exception
     *             thrown cause failure
     */
    public void testBracketEdgeStyleCustomization() throws Exception {
        testStyleCustomization(superTypeEditPartBot);
    }

    private void testStyleCustomization(SWTBotGefEditPart swtBotGefEditPart) throws Exception {
        // Not available in 4.x specific Tabbar
        if (TestsUtil.isDynamicTabbar()) {
            return;
        }

        if (isSiriusElt(swtBotGefEditPart)) {
            testSiriusStyleCustomizationFromStyleTab(swtBotGefEditPart);
        }
        testGMFStyleCustomization(swtBotGefEditPart);
    }

    private void testSiriusStyleCustomizationFromStyleTab(SWTBotGefEditPart swtBotGefEditPart) throws Exception {
        DDiagramElement dDiagramElement = getDDiagramElement(swtBotGefEditPart);
        View notationView = ((IGraphicalEditPart) swtBotGefEditPart.part()).getNotationView();
        Style viewpointStyle = dDiagramElement.getStyle();
        CustomizableQuery customizableQuery = new CustomizableQuery(viewpointStyle);
        List<String> customizableFeatureNames = customizableQuery.getCustomizableFeatureNames();

        assertSiriusAndGMFStyleSynchronized(viewpointStyle, notationView);

        // Test viewpoint style properties customization from the Style tab of
        // the properties view
        for (String customizableFeatureName : customizableFeatureNames) {
            EStructuralFeature feature = viewpointStyle.eClass().getEStructuralFeature(customizableFeatureName);
            Object initialValue = viewpointStyle.eGet(feature);
            if (customizeSiriusStylePropertyFromStyleTab(swtBotGefEditPart, viewpointStyle, feature)) {
                Object newValue = viewpointStyle.eGet(feature);

                assertSiriusAndGMFStyleSynchronized(viewpointStyle, notationView);

                checkFigure(swtBotGefEditPart, feature);
                String assertMessage = "Only one feature should be customized : " + customizableFeatureName;
                assertEquals(assertMessage, 1, viewpointStyle.getCustomFeatures().size());
                assertEquals(assertMessage, customizableFeatureName, viewpointStyle.getCustomFeatures().get(0));

                // Check that a refresh doesn't change customizations
                selectAndRefreshDiagram();
                viewpointStyle = dDiagramElement.getStyle();

                assertEquals("A refresh shouldn't change the customized style feature", newValue, viewpointStyle.eGet(feature));
                checkFigure(swtBotGefEditPart, feature);
                assertEquals(assertMessage, 1, viewpointStyle.getCustomFeatures().size());
                assertEquals(assertMessage, customizableFeatureName, viewpointStyle.getCustomFeatures().get(0));

                // Reset style properties to default values
                resetStylePropertiesToDefault(swtBotGefEditPart);
                viewpointStyle = dDiagramElement.getStyle();

                assertSiriusAndGMFStyleSynchronized(viewpointStyle, notationView);

                if (isContainmentReference(feature) && initialValue instanceof EObject) {
                    EObject initialEObjectValue = (EObject) initialValue;
                    Object newStyleFeatureValue = viewpointStyle.eGet(feature);
                    assertTrue("The new style feature value must be a EObject as the initial value", newStyleFeatureValue instanceof EObject);
                    EObject newStyleFeatureEobjectValue = (EObject) newStyleFeatureValue;
                    for (EAttribute eAttribute : initialEObjectValue.eClass().getEAllAttributes()) {
                        Object initialEAttributeValue = initialEObjectValue.eGet(eAttribute);
                        Object newEAttributeValue = newStyleFeatureEobjectValue.eGet(eAttribute);
                        assertEquals("After reset style properties to default we should be as at the beginning for feature : " + customizableFeatureName, initialEAttributeValue, newEAttributeValue);
                    }
                } else {
                    assertEquals("After reset style properties to default we should be as at the beginning for feature : " + customizableFeatureName, initialValue, viewpointStyle.eGet(feature));
                }
                checkFigure(swtBotGefEditPart, feature);
                assertEquals("After reset style properties to default we should be as at the beginning for feature : " + customizableFeatureName, 0, viewpointStyle.getCustomFeatures().size());
            }
        }
    }

    private void testGMFStyleCustomization(SWTBotGefEditPart swtBotGefEditPart) throws Exception {
        // Test the GMF style properties customization from the Appearance tab
        // of the property view
        for (EAttribute gmfStyleEAttribute : ViewQuery.CUSTOMIZABLE_GMF_STYLE_ATTRIBUTES) {
            View correspondingView = (View) swtBotGefEditPart.part().getModel();
            org.eclipse.gmf.runtime.notation.Style gmfStyle = correspondingView.getStyle(gmfStyleEAttribute.getEContainingClass());
            if (gmfStyle != null) {
                Object initialValue = gmfStyle.eGet(gmfStyleEAttribute);

                if (customizeGMFStyleProperty(swtBotGefEditPart, gmfStyle, gmfStyleEAttribute)) {
                    Object newValue = gmfStyle.eGet(gmfStyleEAttribute);

                    checkFigure(swtBotGefEditPart, gmfStyleEAttribute);

                    // Check that a refresh doesn't change customizations
                    selectAndRefreshDiagram();
                    correspondingView = (View) swtBotGefEditPart.part().getModel();
                    gmfStyle = correspondingView.getStyle(gmfStyleEAttribute.getEContainingClass());

                    assertEquals("A refresh shouldn't change the customized gmf style feature", newValue, gmfStyle.eGet(gmfStyleEAttribute));
                    checkFigure(swtBotGefEditPart, gmfStyleEAttribute);

                    // Reset style properties to default values
                    resetStylePropertiesToDefault(swtBotGefEditPart);
                    correspondingView = (View) swtBotGefEditPart.part().getModel();
                    gmfStyle = correspondingView.getStyle(gmfStyleEAttribute.getEContainingClass());

                    assertEquals("After reset style properties to default we should be as at the beginning for feature : " + gmfStyleEAttribute.getEContainingClass().getName() + "."
                            + gmfStyleEAttribute.getName(), initialValue, gmfStyle.eGet(gmfStyleEAttribute));
                    checkFigure(swtBotGefEditPart, gmfStyleEAttribute);
                }
            }
        }
    }

    private void assertSiriusAndGMFStyleSynchronized(Style viewpointStyle, View notationView) {
        for (Object obj : notationView.getStyles()) {
            if (obj instanceof org.eclipse.gmf.runtime.notation.Style) {
                org.eclipse.gmf.runtime.notation.Style gmfStyle = (org.eclipse.gmf.runtime.notation.Style) obj;
                for (EAttribute gmfStyleAttribute : gmfStyle.eClass().getEAllAttributes()) {
                    if (ViewQuery.CUSTOMIZABLE_GMF_STYLE_ATTRIBUTES.contains(gmfStyleAttribute) && !ViewQuery.CUSTOMIZABLE_GMF_EXCLUSIVE_STYLE_ATTRIBUTES.contains(gmfStyleAttribute)) {
                        EStructuralFeature viewpointStyleFeature = ViewPropertiesSynchronizer.GMF_TO_DDIAGRAMELEMENT_STYLE_FEATURES_MAPPING.get(gmfStyleAttribute);
                        if (viewpointStyleFeature instanceof EAttribute && viewpointStyle.eClass().getEAllStructuralFeatures().contains(viewpointStyleFeature)) {
                            Object viewpointStylePropertyValue = null;
                            if (viewpointStyle instanceof EdgeStyle) {
                                EdgeStyle viewpointEdgeStyle = (EdgeStyle) viewpointStyle;
                                viewpointStylePropertyValue = viewpointEdgeStyle.getCenterLabelStyle().eGet(viewpointStyleFeature);
                            } else {
                                viewpointStylePropertyValue = viewpointStyle.eGet(viewpointStyleFeature);
                            }
                            Object gmfStylePropertyValue = convertToSiriusPropertyValue(gmfStyle, gmfStyleAttribute);
                            if (viewpointStylePropertyValue != null && !viewpointStylePropertyValue.equals(gmfStylePropertyValue)) {
                                fail("The viewpoint style " + viewpointStyle + " and gmf style " + gmfStyle + " are not synchronized on feature " + viewpointStyleFeature.getName());
                            }
                        }
                    }
                }
            }
        }
    }

    private Object convertToSiriusPropertyValue(org.eclipse.gmf.runtime.notation.Style gmfStyle, EAttribute gmfStyleAttribute) {
        Object gmfStylePropertyValue = gmfStyle.eGet(gmfStyleAttribute);
        if (gmfStyleAttribute == NotationPackage.Literals.FONT_STYLE__BOLD || gmfStyleAttribute == NotationPackage.Literals.FONT_STYLE__ITALIC) {
            FontStyle gmfFontStyle = (FontStyle) gmfStyle;
            if (gmfFontStyle.isBold() && gmfFontStyle.isItalic()) {
                gmfStylePropertyValue = FontFormat.BOLD_ITALIC_LITERAL;
            } else if (gmfFontStyle.isBold()) {
                gmfStylePropertyValue = FontFormat.BOLD_LITERAL;
            } else if (gmfFontStyle.isItalic()) {
                gmfStylePropertyValue = FontFormat.ITALIC_LITERAL;
            } else {
                gmfStylePropertyValue = FontFormat.NORMAL_LITERAL;
            }
        }
        return gmfStylePropertyValue;
    }
}
