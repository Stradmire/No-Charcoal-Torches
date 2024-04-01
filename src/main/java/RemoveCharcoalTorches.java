import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.ShapedRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.CraftingRecipeManager;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import java.util.List;

public class RemoveCharcoalTorches {

    @EventListener
    public void registerItems(RecipeRegisterEvent event) {
        List<CraftingRecipe> recipes = CraftingRecipeManager.getInstance().getRecipes();
        for (int i = 0; i < recipes.size(); i++){
            CraftingRecipe recipe = recipes.get(i);
            if(recipe.getOutput().itemId == Block.TORCH.asItem().id){
                ItemStack[] itemstack = {new ItemStack(Item.COAL.id, 1, 0), new ItemStack(Item.STICK.id, 1, 0)};
                recipes.set(i, new ShapedRecipe(1, 2, itemstack, new ItemStack(Block.TORCH.asItem(), 4)));
            }
        }
    }
}