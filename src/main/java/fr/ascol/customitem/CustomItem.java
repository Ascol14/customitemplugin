package fr.ascol.customitem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItem extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        ItemManager.init();

        Bukkit.addRecipe(getRecipe());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private ShapedRecipe getRecipe() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(1234567);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "custom_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', Material.GOLD_BLOCK);
        recipe.setIngredient('R', Material.BLAZE_ROD);

        return recipe;
    }
}
