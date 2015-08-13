/**
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Obeo - initial API and implementation
 * 
 */
package org.eclipse.sirius.description.contribution.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.sirius.description.contribution.util.ContributionAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ContributionItemProviderAdapterFactory extends ContributionAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement
     * {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public ContributionItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.IgnoreFeatureContribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected IgnoreFeatureContributionItemProvider ignoreFeatureContributionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.IgnoreFeatureContribution}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createIgnoreFeatureContributionAdapter() {
        if (ignoreFeatureContributionItemProvider == null) {
            ignoreFeatureContributionItemProvider = new IgnoreFeatureContributionItemProvider(this);
        }

        return ignoreFeatureContributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.SetFeatureContribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SetFeatureContributionItemProvider setFeatureContributionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.SetFeatureContribution}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSetFeatureContributionAdapter() {
        if (setFeatureContributionItemProvider == null) {
            setFeatureContributionItemProvider = new SetFeatureContributionItemProvider(this);
        }

        return setFeatureContributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.AddFeatureContribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AddFeatureContributionItemProvider addFeatureContributionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.AddFeatureContribution}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAddFeatureContributionAdapter() {
        if (addFeatureContributionItemProvider == null) {
            addFeatureContributionItemProvider = new AddFeatureContributionItemProvider(this);
        }

        return addFeatureContributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.RemoveFeatureContribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected RemoveFeatureContributionItemProvider removeFeatureContributionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.RemoveFeatureContribution}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRemoveFeatureContributionAdapter() {
        if (removeFeatureContributionItemProvider == null) {
            removeFeatureContributionItemProvider = new RemoveFeatureContributionItemProvider(this);
        }

        return removeFeatureContributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.ClearFeatureContribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ClearFeatureContributionItemProvider clearFeatureContributionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.ClearFeatureContribution}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createClearFeatureContributionAdapter() {
        if (clearFeatureContributionItemProvider == null) {
            clearFeatureContributionItemProvider = new ClearFeatureContributionItemProvider(this);
        }

        return clearFeatureContributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.ResetFeatureContribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ResetFeatureContributionItemProvider resetFeatureContributionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.ResetFeatureContribution}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createResetFeatureContributionAdapter() {
        if (resetFeatureContributionItemProvider == null) {
            resetFeatureContributionItemProvider = new ResetFeatureContributionItemProvider(this);
        }

        return resetFeatureContributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.DirectEObjectReference} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected DirectEObjectReferenceItemProvider directEObjectReferenceItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.DirectEObjectReference}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDirectEObjectReferenceAdapter() {
        if (directEObjectReferenceItemProvider == null) {
            directEObjectReferenceItemProvider = new DirectEObjectReferenceItemProvider(this);
        }

        return directEObjectReferenceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.ComputedEObjectReference} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ComputedEObjectReferenceItemProvider computedEObjectReferenceItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.ComputedEObjectReference}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createComputedEObjectReferenceAdapter() {
        if (computedEObjectReferenceItemProvider == null) {
            computedEObjectReferenceItemProvider = new ComputedEObjectReferenceItemProvider(this);
        }

        return computedEObjectReferenceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.Contribution} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ContributionItemProvider contributionItemProvider;

    /**
     * This creates an adapter for a
     * {@link org.eclipse.sirius.description.contribution.Contribution}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createContributionAdapter() {
        if (contributionItemProvider == null) {
            contributionItemProvider = new ContributionItemProvider(this);
        }

        return contributionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.description.contribution.ContributionPoint} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ContributionPointItemProvider contributionPointItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.description.contribution.ContributionPoint}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createContributionPointAdapter() {
        if (contributionPointItemProvider == null) {
            contributionPointItemProvider = new ContributionPointItemProvider(this);
        }

        return contributionPointItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to
     * {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void dispose() {
        if (ignoreFeatureContributionItemProvider != null) ignoreFeatureContributionItemProvider.dispose();
        if (setFeatureContributionItemProvider != null) setFeatureContributionItemProvider.dispose();
        if (addFeatureContributionItemProvider != null) addFeatureContributionItemProvider.dispose();
        if (removeFeatureContributionItemProvider != null) removeFeatureContributionItemProvider.dispose();
        if (clearFeatureContributionItemProvider != null) clearFeatureContributionItemProvider.dispose();
        if (resetFeatureContributionItemProvider != null) resetFeatureContributionItemProvider.dispose();
        if (directEObjectReferenceItemProvider != null) directEObjectReferenceItemProvider.dispose();
        if (computedEObjectReferenceItemProvider != null) computedEObjectReferenceItemProvider.dispose();
        if (contributionItemProvider != null) contributionItemProvider.dispose();
        if (contributionPointItemProvider != null) contributionPointItemProvider.dispose();
    }

}
