/*******************************************************************************
 * Copyright (c) 2008 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.maven.ide.eclipse.scm.cvs;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteFolder;

import org.maven.ide.eclipse.scm.ScmUrl;

/**
 * @author Eugene Kuleshov
 */
public class TeamCvsUrlAdapterFactory implements IAdapterFactory {

  private static final Class<?>[] ADAPTER_TYPES = new Class[] { ScmUrl.class };
  
  public Class<?>[] getAdapterList() {
    return ADAPTER_TYPES;
  }
  
  @SuppressWarnings("rawtypes")
  public Object getAdapter(Object adaptable, Class adapterType) {
    if(ScmUrl.class.equals(adapterType)) {
      if(adaptable instanceof ICVSRemoteFolder) {
        return TeamCvsUtil.getScmUrl((ICVSRemoteFolder) adaptable);
      }
    }
    return null;
  }

}
