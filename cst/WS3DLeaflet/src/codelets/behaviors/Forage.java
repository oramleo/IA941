/*****************************************************************************
 * Copyright 2007-2015 DCA-FEEC-UNICAMP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *    Klaus Raizer, Andre Paraense, Ricardo Ribeiro Gudwin
 *****************************************************************************/

package codelets.behaviors;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryContainer;
import br.unicamp.cst.core.entities.MemoryObject;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import ws3dproxy.model.Thing;

/**
 * @author klaus
 */

public class Forage extends Codelet {
    private MemoryContainer legsMC;
    private int legsMCID = -1;


    /**
     * Default constructor
     */
    public Forage() {
    }

    @Override
    public void proc() {
        JSONObject message = new JSONObject();
        try {
            message.put("ACTION", "FORAGE");
            if (legsMCID == -1)
                legsMCID = legsMC.setI(message.toString(), 0.5);
            else
                legsMC.setI(message.toString(), 0.5, legsMCID);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Override
    public void accessMemoryObjects() {
        legsMC = (MemoryContainer) this.getOutput("LEGS_CONTAINER");

        // TODO Auto-generated method stub

    }

    @Override
    public void calculateActivation() {

    }


}
