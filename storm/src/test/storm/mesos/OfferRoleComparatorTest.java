/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package storm.mesos;

import org.apache.mesos.Protos.Offer;
import org.apache.mesos.Protos.Resource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OfferRoleComparatorTest {



  @Test
  public void testCompare() throws Exception {
    List<Resource> aggregatedOffers = new ArrayList<>();
    Offer offer = TestUtils.buildOffer();
    aggregatedOffers.addAll(offer.getResourcesList());
    Collections.sort(aggregatedOffers, new ResourceRoleComparator());

    assertEquals(
        "*",
        aggregatedOffers.get(5).getRole()
    );
    assertEquals(
        "*",
        aggregatedOffers.get(4).getRole()
    );
  }
}
