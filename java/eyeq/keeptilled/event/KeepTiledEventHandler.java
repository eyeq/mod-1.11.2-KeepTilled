package eyeq.keeptilled.event;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KeepTiledEventHandler {
    @SubscribeEvent
    public void onNeighborNotify(BlockEvent.NeighborNotifyEvent event) {
        World world = event.getWorld();
        if(world.isRemote) {
            return;
        }
        BlockPos pos = event.getPos();
        if(event.getState().getBlock() == Blocks.DIRT) {
            Block block = world.getBlockState(pos.up()).getBlock();
            // BlockFarmland ## private boolean hasCrops(World worldIn, BlockPos pos)
            if(block instanceof IPlantable && Blocks.FARMLAND.canSustainPlant(event.getState(), world, pos, EnumFacing.UP, (IPlantable) block)) {
                world.setBlockState(pos, Blocks.FARMLAND.getDefaultState());
            }
        }
    }
}
