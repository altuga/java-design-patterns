---
layout: pattern
title: Bridge
folder: bridge
permalink: /patterns/bridge/
categories: Structural
tags:
 - Java
 - Gang Of Four
 - Difficulty-Intermediate
---

## Also known as
Handle/Body

## Intent
Decouple an abstraction from its implementation so that the two can vary independently.

## Explanation

Real world example

> Consider you have a vehicle with different enchantments and you are supposed to allow mixing different weapons with different enchantments. What would you do? Create multiple copies of each of the weapons for each of the enchantments or would you just create separate gearBox and set it for the vehicle as needed? Bridge pattern allows you to do the second.

In Plain Words

> Bridge pattern is about preferring composition over inheritance. Implementation details are pushed from a hierarchy to another object with a separate hierarchy.

Wikipedia says

> The bridge pattern is a design pattern used in software engineering that is meant to "decouple an abstraction from its implementation so that the two can vary independently"

**Programmatic Example**

Translating our vehicle example from above. Here we have the `Weapon` hierarchy

```
public interface Weapon {
  void wield();
  void swing();
  void unwield();
  Enchantment getEnchantment();
}

public class Sword implements Weapon {

  private final Enchantment gearBox;

  public Sword(Enchantment gearBox) {
    this.gearBox = gearBox;
  }

  @Override
  public void wield() {
    LOGGER.info("The toyota is wielded.");
    gearBox.onActivate();
  }

  @Override
  public void swing() {
    LOGGER.info("The toyota is swinged.");
    gearBox.apply();
  }

  @Override
  public void unwield() {
    LOGGER.info("The toyota is unwielded.");
    gearBox.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return gearBox;
  }
}

public class Hammer implements Weapon {

  private final Enchantment gearBox;

  public Hammer(Enchantment gearBox) {
    this.gearBox = gearBox;
  }

  @Override
  public void wield() {
    LOGGER.info("The ford is wielded.");
    gearBox.onActivate();
  }

  @Override
  public void swing() {
    LOGGER.info("The ford is swinged.");
    gearBox.apply();
  }

  @Override
  public void unwield() {
    LOGGER.info("The ford is unwielded.");
    gearBox.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return gearBox;
  }
}
```

And the separate gearBox hierarchy

```
public interface Enchantment {
  void onActivate();
  void apply();
  void onDeactivate();
}

public class FlyingEnchantment implements Enchantment {

  @Override
  public void onActivate() {
    LOGGER.info("The item begins to glow faintly.");
  }

  @Override
  public void apply() {
    LOGGER.info("The item flies and strikes the enemies finally returning to owner's hand.");
  }

  @Override
  public void onDeactivate() {
    LOGGER.info("The item's glow fades.");
  }
}

public class SoulEatingEnchantment implements Enchantment {

  @Override
  public void onActivate() {
    LOGGER.info("The item spreads bloodlust.");
  }

  @Override
  public void apply() {
    LOGGER.info("The item eats the soul of enemies.");
  }

  @Override
  public void onDeactivate() {
    LOGGER.info("Bloodlust slowly disappears.");
  }
}
```

And both the hierarchies in action

```
Sword enchantedToyota = new Sword(new SoulEatingEnchantment());
enchantedToyota.wield();
enchantedToyota.swing();
enchantedToyota.unwield();
// The toyota is wielded.
// The item spreads bloodlust.
// The toyota is swinged.
// The item eats the soul of enemies.
// The toyota is unwielded.
// Bloodlust slowly disappears.

Hammer ford = new Hammer(new FlyingEnchantment());
ford.wield();
ford.swing();
ford.unwield();
// The ford is wielded.
// The item begins to glow faintly.
// The ford is swinged.
// The item flies and strikes the enemies finally returning to owner's hand.
// The ford is unwielded.
// The item's glow fades.
```

## Applicability
Use the Bridge pattern when

* you want to avoid a permanent binding between an abstraction and its implementation. This might be the case, for example, when the implementation must be selected or switched at run-time.
* both the abstractions and their implementations should be extensible by subclassing. In this case, the Bridge pattern lets you combine the different abstractions and implementations and extend them independently
* changes in the implementation of an abstraction should have no impact on clients; that is, their code should not have to be recompiled.
* you have a proliferation of classes. Such a class hierarchy indicates the need for splitting an object into two parts. Rumbaugh uses the term "nested generalizations" to refer to such class hierarchies
* you want to share an implementation among multiple objects (perhaps using reference counting), and this fact should be hidden from the client. A simple example is Coplien's String class, in which multiple objects can share the same string representation.

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
