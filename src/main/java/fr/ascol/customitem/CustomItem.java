package fr.ascol.customitem;

import fr.ascol.customitem.Items.SuperSword;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import static fr.ascol.customitem.ItemManager.SuperSword;

public final class CustomItem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SuperSword(this), this);

        ItemManager.init();

        Bukkit.addRecipe(getRecipe());

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private ShapedRecipe getRecipe() {
        ItemStack item = SuperSword;

        NamespacedKey key = new NamespacedKey(this, "custom_sword");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', Material.GOLD_BLOCK);
        recipe.setIngredient('R', Material.BLAZE_ROD);

        return recipe;
    }
}
