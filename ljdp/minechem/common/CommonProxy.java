package ljdp.minechem.common;

import net.minecraft.src.World;

public class CommonProxy {
	
	public static String ELEMENTBOTTLES_PNG = "/ljdp/minechem/textures/elementbottles.png";
	public static String DECOMPOSER_GUI_PNG = "/ljdp/minechem/textures/ChemicalDecomposerGUI.png";
	public static String MICROSCOPE_GUI_PNG = "/ljdp/minechem/textures/MicroscopeGUI.png";
	public static String SYNTHESIS_GUI_PNG  = "/ljdp/minechem/textures/SynthesisGUI.png";
	public static String BLOCKS_PNG			= "/ljdp/minechem/textures/blocktextures.png";
	
	public void registerRenderers() {
		
	}
	
	public World getClientWorld() {
		return null;
	}

}
