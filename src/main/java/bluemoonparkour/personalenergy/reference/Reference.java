package bluemoonparkour.personalenergy.reference;

public class Reference
{
    public static final String MOD_ID = "personalEnergy";
    public static final String MOD_NAME = "Personal Energy";
    public static final String VERSION = "1.0.0.2";
    public static final String ACCEPTED_VERISONS = "[1.10.2]";

    public static final String CLIENT_PROXY_CLASS = "bluemoonparkour.personalenergy.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "bluemoonparkour.personalenergy.proxy.ServerProxy";

    public static enum PEItems
    {
        ;
        private String unlocalizedName;
        private String registryName;

        PEItems(String unlocalizedName, String registryName)
        {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName()
        {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }

    public static enum PEBlocks
    {

        JAR("jar", "BlockJar");

        private String unlocalizedName;
        private String registryName;

        PEBlocks(String unlocalizedName, String registryName)
        {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName()
        {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }
}
