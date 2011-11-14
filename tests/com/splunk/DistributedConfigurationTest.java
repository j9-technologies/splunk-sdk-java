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

package com.splunk.sdk.tests.com.splunk;

import com.splunk.*;
import com.splunk.sdk.Program;
import com.splunk.Service;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.*;

public class DistributedConfigurationTest extends TestCase {
    Program program = new Program();

    public DistributedConfigurationTest() {}

    Service connect() {
        return new Service(
            program.host, program.port, program.scheme)
                .login(program.username, program.password);
    }

    @Before public void setUp() {
        this.program.init(); // Pick up .splunkrc settings
    }

    @Test public void testDistributedConfiguration() throws Exception {
        Service service = connect();

        DistributedConfiguration dc = service.getDistributedConfiguration();
        dc.getAutoAddServers();
        dc.getBlacklistNames();
        dc.getBlacklistUrls();
        dc.getCheckTimedOutServersFrequency();
        dc.isDisabled();
        dc.getHeartbeatFrequency();
        dc.getHeartbeatMcastAddress();
        dc.getHeartbeatPort();
        dc.getRemovedTimedOutServers();
        dc.getServerTimeout();
        dc.getServers();
        dc.getShareBundles();
        dc.getSkipOurselves();
        dc.getStatusTimeout();
        dc.getTtl();
    }
}