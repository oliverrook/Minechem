package ljdp.minechem.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import ljdp.minechem.api.core.EnumElement;
import ljdp.minechem.common.ModMinechem;
import ljdp.minechem.common.items.ItemAtomicManipulator;
import ljdp.minechem.common.items.ItemElement;
import ljdp.minechem.common.items.ItemFusionStar;
import ljdp.minechem.common.items.ItemLens;
import ljdp.minechem.common.items.ItemMolecule;
import ljdp.minechem.common.utils.MinechemHelper;

public class MinechemItems {
	public static ItemElement element;
	public static ItemMolecule molecule;
	public static ItemLens lens;
	public static ItemAtomicManipulator atomicManipulator;
	public static ItemStack convexLens;
	public static ItemStack concaveLens;
	public static ItemStack microscopeLens;
	public static ItemFusionStar fusionStar;
	
	private static int elementID;
	private static int moleculeID;
	private static int atomicManipulatorID;
	private static int lensID;
	private static int fusionStarID;
	
	
	public static void loadConfig(Configuration config) {
		elementID   = config.getItem(config.CATEGORY_ITEM, "Element", 4736).getInt(4736);
	 	moleculeID  = config.getItem(config.CATEGORY_ITEM, "Molecule", 4737).getInt(4737);
	 	lensID	 	= config.getItem(config.CATEGORY_ITEM, "Lens", 4738).getInt(4738);
	 	atomicManipulatorID = config.getItem(config.CATEGORY_ITEM, "AtomicManipulator", 4739).getInt(4739);
	 	fusionStarID = config.getItem(config.CATEGORY_ITEM, "FusionStar", 4740).getInt(4740);
	}
	
	public static void registerItems() {
		element  = new ItemElement(elementID);
		molecule = new ItemMolecule(moleculeID);
		lens	 = new ItemLens(lensID);
		atomicManipulator = new ItemAtomicManipulator(atomicManipulatorID);
		concaveLens = new ItemStack(lens, 1, 0);
		convexLens  = new ItemStack(lens, 1, 1);
		microscopeLens = new ItemStack(lens, 1, 2);
		fusionStar  = new ItemFusionStar(fusionStarID);
		LanguageRegistry.addName(atomicManipulator, MinechemHelper.getLocalString("item.name.atomicmanipulator"));
		LanguageRegistry.addName(fusionStar, MinechemHelper.getLocalString("item.name.fusionStar"));
	}
	
	public static void registerToOreDictionary() {
		for(EnumElement element : EnumElement.values()) {
			OreDictionary.registerOre("element" + element.descriptiveName(), new ItemStack(MinechemItems.element, 1, element.ordinal()));
		}
	}
}
