package mca.items;

import java.util.List;

import mca.blocks.BlockVillagerBed;
import mca.core.MCA;
import mca.core.minecraft.ModBlocks;
import mca.enums.EnumBedColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import radixcore.util.BlockHelper;

public class ItemVillagerBed extends Item
{
	private EnumBedColor color;
	
	public ItemVillagerBed(EnumBedColor color)
	{
		final String itemName = "ItemVillagerBed" + color.toString();
		
		this.color = color;
		this.setCreativeTab(MCA.getCreativeTabMain());
		this.setMaxStackSize(1);
		this.setUnlocalizedName(itemName);

		GameRegistry.registerItem(this, itemName);
	}

	private BlockVillagerBed getBedBlock()
	{
		switch (color)
		{
		case BLUE:
			return ModBlocks.bedBlue;
		case GREEN:
			return ModBlocks.bedGreen;
		case PINK:
			return ModBlocks.bedPink;
		case PURPLE:
			return ModBlocks.bedPurple;
		case RED:
			return ModBlocks.bedRed;
		default:
			return null;
		}
	}
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World worldObj, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		return true;
//		int posX = pos.getX();
//		int posY = pos.getY();
//		int posZ = pos.getZ();
//		
//		if (worldObj.isRemote)
//		{
//			return true;
//		}
//
//		else if (meta != 1)
//		{
//			return false;
//		}
//
//		else
//		{
//			++posY;
//			final BlockVillagerBed blockVillagerBed = getBedBlock();
//
//			final int metaCalc = MathHelper.floor_double(entityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
//
//			byte movX = 0;
//			byte movZ = 0;
//
//			if (metaCalc == 0)
//			{
//				movZ = 1;
//			}
//
//			if (metaCalc == 1)
//			{
//				movX = -1;
//			}
//
//			if (metaCalc == 2)
//			{
//				movZ = -1;
//			}
//
//			if (metaCalc == 3)
//			{
//				movX = 1;
//			}
//
//			if (entityPlayer.canPlayerEdit(posX, posY, posZ, meta, itemStack) && entityPlayer.canPlayerEdit(posX + movX, posY, posZ + movZ, meta, itemStack))
//			{
//				if (world.isAirBlock(posX, posY, posZ) && world.isAirBlock(posX + movX, posY, posZ + movZ) && BlockHelper.doesBlockHaveSolidTopSurface(world, posX, posY - 1, posZ) && BlockHelper.doesBlockHaveSolidTopSurface(world, posX + movX, posY - 1, posZ + movZ))
//				{
//					BlockHelper.setBlock(world, posX, posY, posZ, blockVillagerBed, metaCalc);
//
//					if (BlockHelper.getBlock(world, posX, posY, posZ) == blockVillagerBed)
//					{
//						BlockHelper.setBlock(world, posX + movX, posY, posZ + movZ, blockVillagerBed, metaCalc + 8);
//					}
//
//					--itemStack.stackSize;
//					return true;
//				}
//
//				else
//				{
//					return false;
//				}
//			}
//
//			else
//			{
//				return false;
//			}
//		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List informationList, boolean unknown)
	{
		informationList.add(MCA.getLanguageManager().getString("information.villagerbed.line1"));
		informationList.add(MCA.getLanguageManager().getString("information.villagerbed.line2"));
		informationList.add(MCA.getLanguageManager().getString("information.villagerbed.line3"));
	}
}
