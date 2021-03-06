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

import java.util.Random;

import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;

/**
 * @author rgudwin
 */
public class Environment {

    public String host = "localhost";
    public int port = 4011;
    public String robotID = "r0";
    public Creature c = null;

    public Environment() {
        WS3DProxy proxy = new WS3DProxy();
        try {
            World w = World.getInstance();
            w.reset();

            Random rand = new Random();
            int numJoias = 15;
            for (int i = 0; i < numJoias; i++) {
                World.createJewel(rand.nextInt(6),
                        rand.nextInt(w.getEnvironmentWidth() + 1),
                        rand.nextInt(w.getEnvironmentHeight() + 1));
            }
            World.createFood(0, rand.nextInt(800), rand.nextInt(600));
            World.createFood(0, rand.nextInt(800), rand.nextInt(600));
            World.createFood(0, rand.nextInt(800), rand.nextInt(600));


            c = proxy.createCreature(100, 100, 0, 1);
            c.start();
            //c.setRobotID("r0");
            //c.startCamera("r0");


        } catch (CommandExecException e) {

        }
        System.out.println("Robot " + c.getName() + " is ready to go.");


    }
}
