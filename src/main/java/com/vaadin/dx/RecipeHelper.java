package com.vaadin.dx;

public class RecipeHelper {
    public static String getRecipe(String recipeName) {
        if (recipeName == null || recipeName.isBlank()) {
            return null;
        }
        var name = recipeName.trim().toLowerCase();
        if (name.contains("salmon soup")) {
            return """
                    Salmon Soup (Lohikeitto)
                    Ingredients: 400g salmon fillet, 4 potatoes, \
                    2 carrots, 1 onion, 500ml fish stock, 200ml cream, \
                    fresh dill, salt, white pepper
                    Instructions:
                    1. Dice potatoes, carrots, and onion
                    2. Boil vegetables in fish stock until tender (15 min)
                    3. Cut salmon into chunks, add to pot
                    4. Simmer 5 minutes until salmon is cooked
                    5. Add cream, season with salt and white pepper
                    6. Garnish with fresh dill and serve""";
        }
        if (name.contains("pancake")) {
            return """
                    Finnish Pancakes (Letut)
                    Ingredients: 3 eggs, 500ml milk, 200ml flour, \
                    1 tbsp sugar, pinch of salt, butter for frying
                    Instructions:
                    1. Whisk eggs and sugar together
                    2. Add milk and flour alternately, mixing until smooth
                    3. Add salt, let batter rest 30 minutes
                    4. Heat butter in a pan, pour thin layer of batter
                    5. Cook until golden on both sides
                    6. Serve with jam and whipped cream""";
        }
        if (name.contains("karelian")
                || name.contains("karjalan")) {
            return """
                    Karelian Pies (Karjalanpiirakat)
                    Ingredients: Crust: 300ml rye flour, 100ml water, \
                    pinch of salt. Filling: 200ml rice, 1L milk, salt
                    Instructions:
                    1. Cook rice porridge: bring milk to boil, add rice, \
                    simmer 30 min
                    2. Mix rye flour, water, and salt into dough
                    3. Roll thin ovals, spread rice filling on each
                    4. Fold edges up, crimp with fingers
                    5. Bake at 250C for 15 minutes
                    6. Brush with butter while hot, serve with egg butter""";
        }
        return "Recipe not found for: " + recipeName
                + ". Available recipes: Salmon Soup, "
                + "Finnish Pancakes, Karelian Pies.";
    }
}
