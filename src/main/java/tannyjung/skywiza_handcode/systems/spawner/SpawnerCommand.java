
package tannyjung.skywiza_handcode.systems.spawner;

import tannyjung.skywiza.procedures.COMMANDSpawnerRespawnProcedure;
import tannyjung.skywiza.procedures.COMMANDSpawnerLoopSecondProcedure;
import tannyjung.skywiza.procedures.COMMANDSpawnerLoopSecondMobProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class SpawnerCommand {

    @SubscribeEvent
    public static void registerCommand (RegisterCommandsEvent event) {

        event.getDispatcher().register(Commands.literal("SKYWIZA").requires(s -> s.hasPermission(2)).then(Commands.literal("event").then(Commands.literal("spawner").then(Commands.literal("respawn").executes(arguments -> {
            Level world = arguments.getSource().getUnsidedLevel();
            double x = arguments.getSource().getPosition().x();
            double y = arguments.getSource().getPosition().y();
            double z = arguments.getSource().getPosition().z();
            Entity entity = arguments.getSource().getEntity();
            if (entity == null && world instanceof ServerLevel _servLevel)
                entity = FakePlayerFactory.getMinecraft(_servLevel);
            Direction direction = Direction.DOWN;
            if (entity != null)
                direction = entity.getDirection();

            COMMANDSpawnerRespawnProcedure.execute(world, x, y, z);
            return 0;
        })))).then(Commands.literal("dev").then(Commands.literal("spawner").then(Commands.literal("loop_second").executes(arguments -> {
            Level world = arguments.getSource().getUnsidedLevel();
            double x = arguments.getSource().getPosition().x();
            double y = arguments.getSource().getPosition().y();
            double z = arguments.getSource().getPosition().z();
            Entity entity = arguments.getSource().getEntity();
            if (entity == null && world instanceof ServerLevel _servLevel)
                entity = FakePlayerFactory.getMinecraft(_servLevel);
            Direction direction = Direction.DOWN;
            if (entity != null)
                direction = entity.getDirection();

            COMMANDSpawnerLoopSecondProcedure.execute(world, x, y, z, entity);
            return 0;
        })).then(Commands.literal("loop_second_mob").executes(arguments -> {
            Level world = arguments.getSource().getUnsidedLevel();
            double x = arguments.getSource().getPosition().x();
            double y = arguments.getSource().getPosition().y();
            double z = arguments.getSource().getPosition().z();
            Entity entity = arguments.getSource().getEntity();
            if (entity == null && world instanceof ServerLevel _servLevel)
                entity = FakePlayerFactory.getMinecraft(_servLevel);
            Direction direction = Direction.DOWN;
            if (entity != null)
                direction = entity.getDirection();

            COMMANDSpawnerLoopSecondMobProcedure.execute(arguments, entity);
            return 0;
        })))));

    }

}
