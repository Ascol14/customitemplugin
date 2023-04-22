package fr.ascol.customitem.Items;

import fr.ascol.customitem.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class SuperSword implements Listener {

    CustomItem plugin;

    public SuperSword(CustomItem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null
        && event.getCurrentItem().getItemMeta().getLore() != null
        && event.getCurrentItem().getItemMeta().getLore().contains("§6Super Sword §caracteristique :")) {
            String zombie = plugin.getConfig().getString("supersword.zombie");
            ItemMeta meta = event.getCurrentItem().getItemMeta();
            event.getCurrentItem().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Player player = (Player) event.getDamager();
        if (player.getInventory().getItemInMainHand().getItemMeta() != null
        && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null
        && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Super Sword §7caracteristique :")) {
            if (event.getEntity() instanceof Zombie) {
                int zombie = plugin.getConfig().getInt("supersword.zombie");
                event.setDamage(event.getDamage() * zombie / 100);
            } else {
                event.setCancelled(true);
            }
            player.sendMessage(String.valueOf(event.getDamage()));
        }
    }
}
