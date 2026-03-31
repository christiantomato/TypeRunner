package typerunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import typerunner.backend.Word;

public class WordTest {

    private Word word;

    @BeforeEach
    void setUp() {
        word = new Word(
            "testword" // fullText
            //100 // pointsValue
        );
    }

        @Test
        void testBasic() {
            assertEquals(2,1 + 1);
        }

        @Test
        void testConstructorAndGetters() {
            assertEquals("testword", word.getFullText());
            assertEquals(100, word.getPointsValue());
        }

        @Test
        void testGetTypeIndex() {
            assertEquals(0, word.getTypeIndex());
        }

        @Test
        void testCheckCharacterMatch() {
            assertEquals(0, word.getTypeIndex());
            assertEquals(true, word.checkCharacterMatch('t'));
            assertEquals(1, word.getTypeIndex());
            assertEquals(true, word.checkCharacterMatch('e'));
            assertEquals(2, word.getTypeIndex());
            assertEquals(false, word.checkCharacterMatch('x')); // Incorrect character
            assertEquals(2, word.getTypeIndex()); // Type index should not advance
        }

        @Test
        void testIsComplete() {
            assertEquals(false, word.isComplete());
            word.checkCharacterMatch('t');
            word.checkCharacterMatch('e');
            word.checkCharacterMatch('s');
            word.checkCharacterMatch('t');
            word.checkCharacterMatch('w');
            word.checkCharacterMatch('o');
            word.checkCharacterMatch('r');
            assertEquals(false, word.isComplete()); // Not complete yet
            word.checkCharacterMatch('d');
            assertEquals(true, word.isComplete()); // Now it should be complete
        }

        @Test
        void testGetRemainingText() {
            assertEquals("testword", word.getRemainingText());
            word.checkCharacterMatch('t');
            assertEquals("estword", word.getRemainingText());
            word.checkCharacterMatch('e');
            assertEquals("stword", word.getRemainingText());
            word.checkCharacterMatch('s');
            assertEquals("tword", word.getRemainingText());
            word.checkCharacterMatch('t');
            assertEquals("word", word.getRemainingText());
            word.checkCharacterMatch('w');
            assertEquals("ord", word.getRemainingText());
            word.checkCharacterMatch('o');
            assertEquals("rd", word.getRemainingText());
            word.checkCharacterMatch('r');
            assertEquals("d", word.getRemainingText());
            word.checkCharacterMatch('d');
            assertEquals("", word.getRemainingText()); // Should be empty when complete
        }
   
}
