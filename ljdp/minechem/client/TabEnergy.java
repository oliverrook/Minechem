package ljdp.minechem.client;

import ljdp.minechem.common.MinechemPowerProvider;
import ljdp.minechem.common.ModMinechem;
import ljdp.minechem.utils.RollingAverage;
import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.core.utils.StringUtil;
import net.minecraft.client.gui.Gui;

public class TabEnergy extends Tab {
	
	// I'm copying the layout for the buildcraft
	// engine tab, because users will be familiar.
	int headerColour = 0xe1c92f;
	int subheaderColour = 0xaaafb8;
	int textColour = 0x000000;
	IPowerReceptor powerReceptor;
	float lastEnergy = 0;
	RollingAverage energyUsageRolling =  new RollingAverage(100);
	
	public TabEnergy(Gui gui, IPowerReceptor powerReceptor) {
		super(gui);
		this.maxWidth = 120;
		this.maxHeight = 100;
		this.powerReceptor = powerReceptor;
		this.overlayColor = 0xFF8800;
	}

	@Override
	public void draw(int x, int y) {
		drawBackground(x, y);
		drawIcon(ModMinechem.proxy.ICONS_PNG, 0, x+2, y+2);
		if(!isFullyOpened())
			return;
		
		MinechemPowerProvider provider = (MinechemPowerProvider) powerReceptor.getPowerProvider();
		energyUsageRolling.add(provider.getCurrentEnergyUsage());
		fontRenderer.drawStringWithShadow("Energy", x + 22, y + 8, headerColour);
		fontRenderer.drawStringWithShadow("Usage" + ":", x + 22, y + 20, subheaderColour);
		fontRenderer.drawString(String.format("%.1f", energyUsageRolling.getAverage()) + " MJ/t", x + 22, y + 32, textColour);
		fontRenderer.drawStringWithShadow("Max Usage" + ":", x + 22, y + 44, subheaderColour);
		fontRenderer.drawString(provider.getMaxEnergyReceived() + " MJ/t", x + 22, y + 56, textColour);
		fontRenderer.drawStringWithShadow("Stored" + ":", x + 22, y + 68, subheaderColour);
		fontRenderer.drawString(String.format("%.1f", provider.getEnergyStored()) + " MJ", x + 22, y + 80, textColour);
	}

	@Override
	public String getTooltip() {
		MinechemPowerProvider provider = (MinechemPowerProvider) powerReceptor.getPowerProvider();
		return String.format("%.1f", provider.getCurrentEnergyUsage()) + " MJ/t";
	}

}
