package bluemoonparkour.personalenergy.blocks;

import bluemoonparkour.personalenergy.PersonalEnergy;
import bluemoonparkour.personalenergy.reference.Reference;
import bluemoonparkour.personalenergy.tileentity.TileEntityJar;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockJar extends Block implements ITileEntityProvider
{

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 12, 0.0625 * 13);
    private static final AxisAlignedBB COLLISION_BOX = new AxisAlignedBB(0.0625 * 4, 0, 0.0625 * 4, 0.0625 * 12, 0.0625 * 11, 0.0625 * 12);

    public BlockJar() {
        super(Material.GLASS);
        setUnlocalizedName(Reference.PEBlocks.JAR.getUnlocalizedName());
        setRegistryName(Reference.PEBlocks.JAR.getRegistryName());
        setCreativeTab(PersonalEnergy.CREATIVE_TABS);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, COLLISION_BOX);
    }

   @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
       if (!worldIn.isRemote) {
           TileEntity tileEntity = worldIn.getTileEntity(pos);
           if (tileEntity instanceof TileEntityJar) {
               TileEntityJar jar = (TileEntityJar) tileEntity;
               if (heldItem != null) {
                   if (heldItem.getItem() == Items.IRON_INGOT) {
                       if (jar.addIngot()) {
                           heldItem.stackSize--;
                           return true;
                       }
                   }
               }
               jar.removeIngot();
           }
       }
       return true;
   }

   @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
   {
       return new TileEntityJar();
   }
}

