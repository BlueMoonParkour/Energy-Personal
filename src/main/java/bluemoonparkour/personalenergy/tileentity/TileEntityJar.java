package bluemoonparkour.personalenergy.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntityJar extends TileEntity
{
    private int ingotCount = 0;

    public boolean addIngot(){
        if(ingotCount < 8){
            ingotCount++;
            return true;
        }
        return false;
    }

    public void removeIngot(){
        if(ingotCount > 0){
            worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + .05, pos.getY() + 1.0, pos.getZ() + .5, new ItemStack(Items.IRON_INGOT)));
            ingotCount--;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("IngotCount", this.ingotCount);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.ingotCount = compound.getInteger("IngotCount");
    }
}
