/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.tests.unit.diagram.format.data;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test that shared external references between the source and target model are properly handled: The target diagram
 * contains the external references as well. The layout is properly applied.
 * 
 * @author fbarbin
 */
@RunWith(value = Parameterized.class)
public class MappingBasedSiriusFormatDataManagerExternalRefTest extends MappingBasedSiriusFormatDataManagerCreateTargetDiagramTest {



    protected static final Diagram MB_DIAG_TYPE12_MYPACKAGE = new Diagram("DiagType12 of MyPackage", 16, 2);


    protected static final Representation MB_REPRES_TYPE12 = new Representation("DiagType12", MB_DIAG_TYPE12_MYPACKAGE);


    public MappingBasedSiriusFormatDataManagerExternalRefTest(Representation representationToCopyFormat) throws Exception {
        super(representationToCopyFormat);
    }

    @Override
    protected String getSemanticModelName() {
        return "srcWithExternal.ecore";
    }

    @Override
    protected String getSemanticTargetModelName() {
        return "targetWithExternal.ecore";
    }

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<>();
        data.add(new Object[] { MB_REPRES_TYPE12 });
        return data;
    }
}
