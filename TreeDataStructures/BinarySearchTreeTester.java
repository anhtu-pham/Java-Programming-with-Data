import org.junit.*;
import static org.junit.Assert.*;
// Class BinarySearchTreeTester is tester class for BinarySearchTree
public class BinarySearchTreeTester{
  
  /**
   * Tests the insert method of BinarySearchTree.
   */
  @Test
  public void testInsert(){
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
    
    // insert when tree is empty
    tree.insert(3, "3");
    String[] result1 = {"3"};
    assertArrayEquals(result1, tree.inorderRec().toArray());
    
    // insert when tree has 1 node
    tree.insert(5, "5");
    String[] result2 = {"3", "5"};
    assertArrayEquals(result2, tree.inorderRec().toArray());
    
    // insert when tree has many nodes
    tree.insert(1, "1");
    tree.insert(7, "7");
    tree.insert(0, "0");
    String[] result3 = {"0", "1", "3", "5", "7"};
    assertArrayEquals(result3, tree.inorderRec().toArray());
    
    // when tree has many nodes, insert node having key that is smaller than a node's key but larger than another node's key when going down in the tree
    tree.insert(2, "2");
    String[] result4 = {"0", "1", "2", "3", "5", "7"};
    assertArrayEquals(result4, tree.inorderRec().toArray());
  }
  
  /**
   * Tests the search method of BinarySearchTree.
   */
  @Test
  public void testSearch(){
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
    
    // search when the tree is empty
    assertNull(tree.search(5));
    
    tree.insert(3, "3");
    
    // search when the tree has only 1 node
    assertEquals("3", tree.search(3));
    
    // search with key that is not equal to node's key in the tree when the tree has only 1 node
    assertNull(tree.search(8));
    
    tree.insert(2, "2");
    tree.insert(4, "4");
    tree.insert(0, "0");
    
    // when the tree has many nodes, find value in node in left subtree of the tree's root
    assertEquals("2", tree.search(2));
    
    // when the tree has many nodes, find value in node in right subtree of the tree's root
    assertEquals("4", tree.search(4));
    
    tree.insert(1, "1");
    
    // when the tree has many nodes, find value in node having key that is smaller than a node's key but larger than another node's key when going down in the tree
    assertEquals("1", tree.search(1));
  }
  
  /**
   * Tests the delete method of BinarySearchTree.
   */
  @Test
  public void testDelete(){
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
    
    // delete when tree is empty
    tree.delete(10);
    String[] result1 = {};
    assertArrayEquals(result1, tree.inorderRec().toArray());
    
    tree.insert(5, "5");
    
    // delete with key that is not equal to node's key in the tree when the tree has only 1 node
    tree.delete(20);
    String[] result2 = {"5"};
    assertArrayEquals(result2, tree.inorderRec().toArray());
    
    // delete with key that is equal to node's key in the tree when the tree has only 1 node
    tree.delete(5);
    String[] result3 = {};
    assertArrayEquals(result3, tree.inorderRec().toArray());
    
    tree.insert(4, "4");
    tree.insert(2, "2");
    tree.insert(7, "7");
    tree.insert(9, "9");
    tree.insert(1, "1");
    tree.insert(0, "0");
    tree.insert(8, "8");
    tree.insert(3, "3");
    
    // delete with key that is not equal to any nodes' keys in the tree when the tree has many nodes
    tree.delete(12);
    String[] result4 = {"0", "1", "2", "3", "4", "7", "8", "9"};
    assertArrayEquals(result4, tree.inorderRec().toArray());
    
    // delete node that has no child when the tree has many nodes
    tree.delete(8);
    String[] result5 = {"0", "1", "2", "3", "4", "7", "9"};
    assertArrayEquals(result5, tree.inorderRec().toArray());
    
    // delete node that has 1 child when the tree has many nodes
    tree.delete(1);
    String[] result6 = {"0", "2", "3", "4", "7", "9"};
    assertArrayEquals(result6, tree.inorderRec().toArray());
    
    // delete node that has 2 children when the tree has many nodes
    tree.delete(4);
    String[] result7 = {"0", "2", "3", "7", "9"};
    assertArrayEquals(result7, tree.inorderRec().toArray());
  }
  
  /**
   * Tests the inorderRec method of BinarySearchTree.
   */
  @Test
  public void testInorderRec(){
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
    
    // test inorderRec when tree is empty
    String[] result1 = {};
    assertArrayEquals(result1, tree.inorderRec().toArray());
    
    tree.insert(8, "8");
    
    // test inorderRec when tree has only 1 node
    String[] result2 = {"8"};
    assertArrayEquals(result2, tree.inorderRec().toArray());
    
    tree.insert(9, "9");
    tree.insert(3, "3");
    tree.insert(5, "5");
    tree.insert(6, "6");
    tree.insert(1, "1");
    
    // test inorderRec when tree has many nodes
    String[] result3 = {"1", "3", "5", "6", "8", "9"};
    assertArrayEquals(result3, tree.inorderRec().toArray());
  }
  
  /**
   * Tests the kthSmallest method of BinarySearchTree.
   */
  @Test
  public void testKthSmallest(){
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
    
    // test kthSmallest when tree is empty
    try{
      tree.kthSmallest(2);
      fail("did not throw exception");
    }
    catch(IndexOutOfBoundsException exception){
    }
    catch(Exception exception){
      fail("did not throw IndexOutOfBoundsException exception");
    }
    
    tree.insert(6, "6");
    
    // test kthSmallest with k being 1 when tree has only 1 node
    assertEquals("6", tree.kthSmallest(1));
    
    // test kthSmallest with k being out of bounds when tree has only 1 node
    try{
      tree.kthSmallest(12);
      fail("did not throw exception");
    }
    catch(IndexOutOfBoundsException exception){
    }
    catch(Exception exception){
      fail("did not throw IndexOutOfBoundsException exception");
    }
    try{
      tree.kthSmallest(-5);
      fail("did not throw exception");
    }
    catch(IndexOutOfBoundsException exception){
    }
    catch(Exception exception){
      fail("did not throw IndexOutOfBoundsException exception");
    }
    
    tree.insert(1, "1");
    tree.insert(2, "2");
    tree.insert(9, "9");
    tree.insert(5, "5");
    tree.insert(8, "8");
    tree.insert(0, "0");
    
    // test first for kthSmallest when tree has many nodes
    assertEquals("0", tree.kthSmallest(1));
    
    // test middle for kthSmallest when tree has many nodes
    assertEquals("5", tree.kthSmallest(4));
    
    // test last for kthSmallest when tree has many nodes
    assertEquals("9", tree.kthSmallest(7));
    
    // test kthSmallest with k being out of bounds when tree has many nodes
    try{
      tree.kthSmallest(-14);
      fail("did not throw exception");
    }
    catch(IndexOutOfBoundsException exception){
    }
    catch(Exception exception){
      fail("did not throw IndexOutOfBoundsException exception");
    }
    try{
      tree.kthSmallest(20);
      fail("did not throw exception");
    }
    catch(IndexOutOfBoundsException exception){
    }
    catch(Exception exception){
      fail("did not throw IndexOutOfBoundsException exception");
    }
  }
}