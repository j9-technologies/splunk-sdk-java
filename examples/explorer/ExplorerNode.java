/*
 * Copyright 2011 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Sheet;

// Abstract node that simplifies the creation of node metadata.
abstract class ExplorerNode extends AbstractNode {
    Object value;

    ExplorerNode(Object value) {
        super(new NoKids());
        this.value = value;
    }

    ExplorerNode(Object value, Children kids) {
        super(kids);
        this.value = value;
    }

    abstract PropertyList getMetadata();

    @Override protected Sheet createSheet() {
        return getMetadata().createSheet(value);
    }
}

