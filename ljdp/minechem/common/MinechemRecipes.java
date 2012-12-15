package ljdp.minechem.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.Element;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import static ljdp.minechem.common.EnumElement.*;
import static ljdp.minechem.common.EnumMolecule.*;

public class MinechemRecipes {
	
	/*	The static instance of this class */
	private static final MinechemRecipes instance = new MinechemRecipes();
	
	/* The list of decomposer recipes */
	public HashMap<String, UnbondingRecipe> unbondingRecipes;
	public ArrayList<SynthesisRecipe> synthesisRecipes;
	
	public static MinechemRecipes getInstance() {
		return instance;
	}
	
	private MinechemRecipes() {
		unbondingRecipes = new HashMap<String, UnbondingRecipe>();
		synthesisRecipes = new ArrayList<SynthesisRecipe>();
		addRandomDecomposerRecipe(new ItemStack(Block.stone), 0.3F, 
				itemStacks(element(Si), element(O,2)),
				itemStacks(element(Al,2), element(O,3)),
				itemStacks(element(K,2), element(O,2)),
				itemStacks(element(Na,2), element(O)),
				itemStacks(element(Ca), element(O)),
				itemStacks(element(Fe), element(O)),
				itemStacks(element(Fe,2), element(O,3)),
				itemStacks(element(Mg), element(O)),
				itemStacks(element(Ti), element(O,2)),
				itemStacks(element(P,2), element(O,5)),
				itemStacks(element(Mn), element(O))
				);
		
		addRandomDecomposerRecipe(new ItemStack(Block.cobblestone), 0.1F,
				itemStacks(element(Si), element(O,2)),
				itemStacks(element(Al,2), element(O,3)),
				itemStacks(element(K,2), element(O,2)),
				itemStacks(element(Na,2), element(O)),
				itemStacks(element(Ca), element(O)),
				itemStacks(element(Fe), element(O)),
				itemStacks(element(Fe,2), element(O,3)),
				itemStacks(element(Mg), element(O)),
				itemStacks(element(Ti), element(O,2)),
				itemStacks(element(P,2), element(O,5)),
				itemStacks(element(Mn), element(O))
				);
		
		addRandomDecomposerRecipe(new ItemStack(Block.dirt), 0.01F,
				element(H,2), element(O,6), element(Si), element(Ca), element(C)
				);
		
		addDecomposerRecipe(new ItemStack(Block.oreIron), element(Fe,2));
		addDecomposerRecipe(new ItemStack(Item.ingotIron), element(Fe,1));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Item.ingotIron));
		
		addDecomposerRecipe(new ItemStack(Block.oreGold), element(Au,2));
		addDecomposerRecipe(new ItemStack(Item.ingotGold), element(Au,1));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Item.ingotGold));
		
		addDecomposerRecipe(new ItemStack(Block.oreDiamond), element(C,64), element(C,64));
		addDecomposerRecipe(new ItemStack(Item.diamond), element(C,64));
		addShapedSynthesisRecipe(new ItemStack(Item.diamond), 
				null, 			element(C,64), 		null,
				element(C,64),	null,				element(C,64),
				null,			element(C,64), 		null);
		
		addDecomposerRecipe(new ItemStack(Block.oreCoal), element(C,2));
		addDecomposerRecipe(new ItemStack(Item.coal), element(C,1));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Item.coal));
		
		addDecomposerRecipe(new ItemStack(Item.gunpowder), molecule(potassiumNitrate), element(S,2), element(C,1));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Item.gunpowder));
		
		addDecomposerRecipe(new ItemStack(Block.sand), 		molecule(siliconDioxide, 8));
		addDecomposerRecipe(new ItemStack(Block.glass), 	molecule(siliconDioxide, 16));
		addDecomposerRecipe(new ItemStack(Block.thinGlass), molecule(siliconDioxide,1));
		addDecomposerRecipe(new ItemStack(Block.sandStone), molecule(siliconDioxide,12));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Block.sand));
		
		addDecomposerRecipe(new ItemStack(Block.wood), molecule(cellulose,4));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Block.wood));
		
		addDecomposerRecipe(new ItemStack(Block.oreLapis),
				molecule(lazurite, 4),
				molecule(sodalite, 4),
				molecule(noselite, 4),
				molecule(calcite, 4),
				molecule(pyrite, 4)
				);
		addDecomposerRecipe(new ItemStack(Item.dyePowder, 1, 4), molecule(lazurite));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Item.dyePowder, 1, 4));
		
		addDecomposerRecipe(new ItemStack(Block.glowStone), element(P,4));
		addDecomposerRecipe(new ItemStack(Item.lightStoneDust), element(P));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Item.lightStoneDust));
		
		addDecomposerRecipe(new ItemStack(Block.tnt), molecule(tnt, 4));
		addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(Block.tnt));
		
		// OreDictionary Recipes
		addOreDictDecomposerRecipe("oreSilver", element(Ag,2));
		addOreDictDecomposerAndSynthesisRecipe("ingotSilver", element(Ag));
		addOreDictDecomposerRecipe("oreLead", element(Pb,2));
		addOreDictDecomposerAndSynthesisRecipe("ingotLead", element(Pb));
		addOreDictDecomposerRecipe("oreCopper", element(Cu,2));
		addOreDictDecomposerAndSynthesisRecipe("ingotCopper", element(Cu));
		addOreDictDecomposerRecipe("oreTin", element(Sn,2));
		addOreDictDecomposerAndSynthesisRecipe("ingotTin", element(Sn));
		addOreDictDecomposerRecipe("oreUranium", element(U,2));
		addOreDictDecomposerAndSynthesisRecipe("itemDropUranium", element(U));
		
		addOreDictDecomposerAndSynthesisRecipe("ingotBronze", element(Sn), element(Cu,9));
		addOreDictDecomposerAndSynthesisRecipe("ingotNickel", element(Ni));
		addOreDictDecomposerAndSynthesisRecipe("ingotAluminium", element(Al));
		
	}
	
	private boolean addOreDictDecomposerRecipe(String ore, Object...objects) {
		if(oreNamesHasOre(ore)) {
			int oreID = OreDictionary.getOreID(ore);
			addDecomposerRecipe(new ItemStack(oreID, 1, 0), objects);
			return true;
		}
		return false;
	}
	
	private boolean addOreDictDecomposerAndSynthesisRecipe(String ore, Object...objects) {
		if(addOreDictDecomposerRecipe(ore, objects)) {
			int oreID = OreDictionary.getOreID(ore);
			addUnshapedSynthesisRecipeFromDecomposerRecipe(new ItemStack(oreID, 1, 0));
			return true;
		}
		return false;
	}
	
	private boolean oreNamesHasOre(String ore) {
		String[] oreNames = OreDictionary.getOreNames();
		for(int i = 0; i < oreNames.length; i++) {
			if(oreNames[i].equals(ore))
				return true;
		}
		return false;
	}
	
	private void addDecomposerRecipe(ItemStack input, Object...objects) {
		ArrayList outputStacks = itemStacks(objects);
		UnbondingRecipe unbondingRecipe = new UnbondingRecipe(input, outputStacks);
		unbondingRecipes.put(getKeyFromItemStack(input), unbondingRecipe);
	}
	
	private void addRandomDecomposerRecipe(ItemStack input, float chance, Object...objects) {
		ArrayList outcomes = new ArrayList<ArrayList<ItemStack>>();
		for(int i = 0; i < objects.length; i++) {
			outcomes.add(objects[i]);
		}
		UnbondingRecipeRandom unbondingRecipe = new UnbondingRecipeRandom(input, chance, outcomes);
		unbondingRecipes.put(getKeyFromItemStack(input), unbondingRecipe);
	}
	
	private SynthesisRecipe newSynthesisRecipe(ItemStack output, boolean isShaped, Object...objects) {
		ArrayList inputStacks = itemStacks(objects);
		ItemStack[] recipe = new ItemStack[objects.length];
		for(int i = 0; i < objects.length; i++) {
			recipe[i] = (ItemStack) objects[i];
		}
		return new SynthesisRecipe(output, recipe, isShaped);
	}
	
	private void addShapedSynthesisRecipe(ItemStack output, Object...objects) {
		synthesisRecipes.add(newSynthesisRecipe(output, true, objects));
	}
	
	private void addUnshapedSynthesisRecipe(ItemStack output, Object...objects) {
		synthesisRecipes.add(newSynthesisRecipe(output, false, objects));
	}
	
	private void addUnshapedSynthesisRecipeFromDecomposerRecipe(ItemStack output) {
		ArrayList<ItemStack> inputStacks = getRecipe(output).getOutput();
		ItemStack[] unshapedRecipe = inputStacks.toArray(new ItemStack[inputStacks.size()]);
		SynthesisRecipe synthesisRecipe = new SynthesisRecipe(output, unshapedRecipe, false);
		synthesisRecipes.add(synthesisRecipe);
	}
	
	private ArrayList<ItemStack> itemStacks(Object...objects) {
		ArrayList stacks = new ArrayList<ItemStack>();
		for(int i = 0; i < objects.length; i++) {
			stacks.add((ItemStack)objects[i]);
		}
		return stacks;
	}
	
	private static String getKeyFromItemStack(ItemStack itemstack) {
		return "@"+itemstack.itemID+":"+itemstack.getItemDamage();
	}
	
	public UnbondingRecipe getRecipe(ItemStack itemstack) {
		return unbondingRecipes.get(getKeyFromItemStack(itemstack));
	}
	
	public ItemStack getSynthesisOutput(ItemStack[] inputRecipe) {
		for(SynthesisRecipe recipe : synthesisRecipes) {
			if(recipe.matches(inputRecipe)) {
				return recipe.getOutputStack();
			}
		}
		return null;
	}
	
	public ItemStack[] getSynthesisRecipe(ItemStack outputStack) {
		for(SynthesisRecipe recipe : synthesisRecipes) {
			if(recipe.hasOutputStack(outputStack)) {
				return recipe.getShapedRecipe();
			}
		}
		return null;
	}
	
	public ArrayList<ItemStack> getOutputStacksForItem(ItemStack itemstack) {
		UnbondingRecipe recipe = getRecipe(itemstack);
		if(recipe != null)
			return recipe.getOutput();
		return null;
	}
	
	private static ItemStack element(EnumElement enumElement, int amount) {
		return new ItemStack(MinechemItems.element, amount, enumElement.ordinal());
	}
	
	private static ItemStack element(EnumElement enumElement) {
		return new ItemStack(MinechemItems.element, 1, enumElement.ordinal());
	}
	
	private static ItemStack molecule(EnumMolecule molecule, int amount) {
		return new ItemStack(MinechemItems.molecule, amount, molecule.id());
	}
	
	private static ItemStack molecule(EnumMolecule molecule) {
		return new ItemStack(MinechemItems.molecule, 1, molecule.id());
	}
}