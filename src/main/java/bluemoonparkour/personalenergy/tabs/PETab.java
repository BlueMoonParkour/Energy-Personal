package bluemoonparkour.personalenergy.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class PETab extends CreativeTabs
{
    public PETab()
    {
        super("tabPE");
    }

    @Override
    public Item getTabIconItem()
    {
        return Items.IRON_INGOT;
    }
}
