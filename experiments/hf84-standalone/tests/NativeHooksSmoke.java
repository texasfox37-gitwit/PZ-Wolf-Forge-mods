public class NativeHooksSmoke {
    public static void main(String[] args) {
        zombie.characters.IsoPlayer player = new zombie.characters.IsoPlayer();
        zombie.characters.IsoGameCharacter character = new zombie.characters.IsoGameCharacter();
        Object other = new Object();
        if (!player.isPushedByForSeparate(other)) {
            throw new IllegalStateException("Unexpected IsoPlayer behavior");
        }
        character.setBumpedChr(other);
        if (character.bumped != other) {
            throw new IllegalStateException("Unexpected IsoGameCharacter behavior");
        }
        System.out.println("TDDUP_NATIVE_HOOKS_SMOKE_OK");
    }
}
