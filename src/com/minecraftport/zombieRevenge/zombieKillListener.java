package com.minecraftport.zombieRevenge;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class zombieKillListener implements Listener {

    public static main plugin;

    public zombieKillListener(main instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public boolean onZombieDeath(EntityDeathEvent event) {
        if (event.getEntity().getType() == EntityType.ZOMBIE && event.getEntity().getWorld().getTime() >= 12500) {

            if (event.getEntity().getKiller() instanceof Player) {

                double randNumber = Math.round(Math.random() * plugin.spawnChanceInt);

                if (randNumber == 1) {
                    Player p = (Player) event.getEntity().getKiller();
                    Location zombieLoc = event.getEntity().getLocation();
                    World zombiewrld = zombieLoc.getWorld();

                    p.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "As this zombie fell, another rose to take its place!");
                    Zombie zombie = (Zombie) zombiewrld.spawnEntity(zombieLoc, EntityType.ZOMBIE);
                    zombie.setTarget(p);
                    zombie.setCustomName("Strong Risen Zombie");
                    zombie.setCanPickupItems(false);
                    zombie.setCustomNameVisible(true);
                    zombie.setRemoveWhenFarAway(true);
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 18000, 1));
                    zombie.getEquipment().setHelmet(new ItemStack(Material.MOB_SPAWNER, 1));
                    zombie.getEquipment().setHelmetDropChance(0.05F);
                    zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND, 1));
                    zombie.getEquipment().setBootsDropChance(0.3F);
                }
            } else {
                return false;
            }

        }
        return false;
    }
}
