package bluemoonparkour.personalenergy.proxy;

import bluemoonparkour.personalenergy.init.ModBlocks;

public class ClientProxy implements CommonProxy {

    @Override
    public void init()
    {
       // ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

}
