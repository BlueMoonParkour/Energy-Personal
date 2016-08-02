package bluemoonparkour.personalenergy;

import bluemoonparkour.personalenergy.init.ModBlocks;
import bluemoonparkour.personalenergy.proxy.CommonProxy;
import bluemoonparkour.personalenergy.reference.Reference;
import bluemoonparkour.personalenergy.tabs.PETab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERISONS)
public class PersonalEnergy
{
    @Instance
    public static PersonalEnergy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTabs CREATIVE_TABS = new PETab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("PRE INIT");

        ModBlocks.init();
        ModBlocks.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("INIT");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("POST INIT");
    }
}
