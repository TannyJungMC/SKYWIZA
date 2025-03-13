package net.mcreator.skywiza.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.skywiza.world.inventory.QuestPaperGUIMenu;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnTitleProcedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnRewardProcedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnRequesterProcedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnRequestDateProcedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnEndDateProcedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescriptionProcedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription9Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription8Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription7Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription6Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription5Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription4Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription3Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription2Procedure;
import net.mcreator.skywiza.procedures.QuestPaperGUIreturnDescription10Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuestPaperGUIScreen extends AbstractContainerScreen<QuestPaperGUIMenu> {
	private final static HashMap<String, Object> guistate = QuestPaperGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_wax_seal;
	ImageButton imagebutton_rank_e;

	public QuestPaperGUIScreen(QuestPaperGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("skywiza:textures/screens/paper.png"), this.leftPos + -80, this.topPos + -112, 0, 0, 160, 224, 160, 224);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnTitleProcedure.execute(entity), -72, -104, -16777216, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescriptionProcedure.execute(entity), -72, -88, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription2Procedure.execute(entity), -72, -76, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription3Procedure.execute(entity), -72, -64, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnRequesterProcedure.execute(entity), -72, 72, -6737152, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnRequestDateProcedure.execute(entity), -72, 84, -6737152, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnEndDateProcedure.execute(entity), -72, 96, -3381760, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnRewardProcedure.execute(entity), -72, 52, -3368704, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription4Procedure.execute(entity), -72, -52, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription5Procedure.execute(entity), -72, -40, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription6Procedure.execute(entity), -72, -28, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription7Procedure.execute(entity), -72, -16, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription8Procedure.execute(entity), -72, -4, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription9Procedure.execute(entity), -72, 8, -12829636, false);
		guiGraphics.drawString(this.font,

				QuestPaperGUIreturnDescription10Procedure.execute(entity), -72, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.skywiza.quest_paper_gui.label_reward"), -72, 40, -6724096, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_wax_seal = new ImageButton(this.leftPos + 40, this.topPos + 72, 32, 32, 0, 0, 32, new ResourceLocation("skywiza:textures/screens/atlas/imagebutton_wax_seal.png"), 32, 64, e -> {
		});
		guistate.put("button:imagebutton_wax_seal", imagebutton_wax_seal);
		this.addRenderableWidget(imagebutton_wax_seal);
		imagebutton_rank_e = new ImageButton(this.leftPos + 48, this.topPos + 44, 16, 16, 0, 0, 16, new ResourceLocation("skywiza:textures/screens/atlas/imagebutton_rank_e.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_rank_e", imagebutton_rank_e);
		this.addRenderableWidget(imagebutton_rank_e);
	}
}
