//=================================================================================================================
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                           ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 2                                ////
////                                                                                                           ////
////    Task 2                                                                                                 ////
////                                                                                                           ////
////    Проверить скорость работы (добавление, поиск элемента, удаление) следующих коллекций:                  ////
////                                                                                                           ////
////    NOTE: Для наглядности рекомендуется использовать от 10000+ элементов в коллекции                       ////
////    1. Lists (ArrayList vs LinkedList);                                                                    ////
////    2. Sets (HashSet vs TreeSet);                                                                          ////
////    3. Maps (HashMap vs TreeMap).                                                                          ////
////                                                                                                           ////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//=================================================================================================================

package tasks.collections;

import java.util.Scanner;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/25/2018
 */
public class Runner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//============================================ Lists ================================================================
        ArrayListExample arrayListExample = new ArrayListExample(15000);
        LinkedListExample linkedListExample = new LinkedListExample(15000);
        ListTimeComparison listTimeComparison = new ListTimeComparison();

        //Add into Lists
        double timeAddingElementIntoArrayList = arrayListExample.countTimeAddingElement(scan);
        double timeAddingElementIntoLinkedList = linkedListExample.countTimeAddingElement(scan);
        listTimeComparison.compareTimeAddingElement(timeAddingElementIntoArrayList, timeAddingElementIntoLinkedList);

        //Get from Lists
        double timeGettingElementFromArrayList = arrayListExample.countTimeGettingElement(scan);
        double timeGettingElementFromLinkedList = linkedListExample.countTimeGettingElement(scan);
        listTimeComparison.compareTimeGettingElement(timeGettingElementFromArrayList, timeGettingElementFromLinkedList);

        //Remove in Lists
        double timeRemovingElementInArrayList = arrayListExample.countTimeRemovingElement(scan);
        double timeRemovingElementInLinkedList = linkedListExample.countTimeRemovingElement(scan);
        listTimeComparison.compareTimeRemovingElement(timeRemovingElementInArrayList, timeRemovingElementInLinkedList);

// ============================================ Sets ================================================================
        HashSetExample hashSetExample = new HashSetExample(15000);
        TreeSetExample treeSetExample = new TreeSetExample(15000);
        SetTimeComparison setTimeComparison = new SetTimeComparison();

        //Add into Sets
        double timeAddingElementIntoHashSet = hashSetExample.countTimeAddingElement(scan);
        double timeAddingElementIntoTreeSet = treeSetExample.countTimeAddingElement(scan);
        setTimeComparison.compareTimeAddingElement(timeAddingElementIntoHashSet, timeAddingElementIntoTreeSet);

        //Get from Sets
        double timeGettingElementInHashSet = hashSetExample.countTimeGettingElement(scan);
        double timeGettingElementInTreeSet = treeSetExample.countTimeGettingElement(scan);
        setTimeComparison.compareTimeGettingElement(timeGettingElementInHashSet, timeGettingElementInTreeSet);

        //Remove in Sets
        double timeRemovingElementInHashSet = hashSetExample.countTimeRemovingElement(scan);
        double timeRemovingElementInTreeSet = treeSetExample.countTimeRemovingElement(scan);
        setTimeComparison.compareTimeRemovingElement(timeRemovingElementInHashSet, timeRemovingElementInTreeSet);

// ========================================  Maps ===================================================================
        HashMapExample hashMapExample = new HashMapExample(15000);
        TreeMapExample treeMapExample = new TreeMapExample(15000);
        MapTimeComparison mapTimeComparison = new MapTimeComparison();

        //Add into Maps
        double timeAddingElementIntoHashMap = hashMapExample.countTimeAddingElement(scan);
        double timeAddingElementIntoTreeMap = treeMapExample.countTimeAddingElement(scan);
        mapTimeComparison.compareTimeAddingElement(timeAddingElementIntoHashMap, timeAddingElementIntoTreeMap);

        //Get from Maps
        double timeGettingElementFromHashMap = hashMapExample.countTimeGettingElement(scan);
        double timeGettingElementFromTreeMap = treeMapExample.countTimeGettingElement(scan);
        mapTimeComparison.compareTimeGettingElement(timeGettingElementFromHashMap, timeGettingElementFromTreeMap);

        //Remove in Maps
        double timeRemovingElementInHashMap = hashMapExample.countTimeRemovingElement(scan);
        double timeRemovingElementInTreeMap = treeMapExample.countTimeRemovingElement(scan);
        mapTimeComparison.compareTimeRemovingElement(timeRemovingElementInHashMap, timeRemovingElementInTreeMap);
    }
}
