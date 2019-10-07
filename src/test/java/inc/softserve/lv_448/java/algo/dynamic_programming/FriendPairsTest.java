package inc.softserve.lv_448.java.algo.dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FriendPairsTest extends FriendPairs {

  FriendPairs friendPairs;

  @BeforeEach
  void setUp() {
    friendPairs = new FriendPairs();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void countFriendsPairings() {
    assertEquals(1, friendPairs.countFriendsPairings(1));
    assertEquals(4, friendPairs.countFriendsPairings(3));
    assertEquals(26, friendPairs.countFriendsPairings(5));
    assertEquals(764, friendPairs.countFriendsPairings(8));
    assertEquals(10349536, friendPairs.countFriendsPairings(15));
  }

}