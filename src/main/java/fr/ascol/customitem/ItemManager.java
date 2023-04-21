package fr.ascol.customitem;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemManager {

    public static ItemStack SuperSword;

    public static void init() {
        CreateSuperSword();
    }

    private static void CreateSuperSword() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName('§6Super Sword');

        List<String> lore = new ArrayList<>();
        lore.add('§7Damage: §c+70');

        meta.setLore(lore);

        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 70, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setCustomModelData(1234567);

        item.setItemMeta(meta);

        SuperSword = item;
    }
}
