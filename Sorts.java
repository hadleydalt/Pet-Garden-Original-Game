package indy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// This class contains the logic for MergeSort which is implemented to sort the items in the shop according to their price.

public class Sorts {
    private LinkedList<Buyable> _itemsList;
    private ArrayList<Buyable> _items;

    public Sorts(ArrayList<Buyable> items){
        _items = items;
        _itemsList = new LinkedList<Buyable>();
    }

    // MERGESORT: returns a List of buyables by mergesorting them with the Merge method.

    public List<Buyable> mergeSort(List<Buyable> list) {
        if (list.size() == 1) {
            return list;
        }
        int middle = list.size() / 2;
        List<Buyable> left =
                this.mergeSort(list.subList(0, middle));
        List<Buyable> right =
                this.mergeSort(list.subList(middle, list.size()));

        return this.merge(left, right);
    }

    // MERGE: Organizes the order of the array of Buyables to be sorted by comparing their prices.

    public ArrayList<Buyable> merge(List<Buyable> A, List<Buyable> B) {
        ArrayList<Buyable> result = new ArrayList<Buyable>();
        int aIndex = 0;
        int bIndex = 0;
        while ((aIndex < A.size()) && (bIndex < B.size())){
            if ((A.get(aIndex)).getPrice() <= (B.get(bIndex)).getPrice()){
                result.add(A.get(aIndex));
                aIndex++;
            } else {
                result.add(B.get(bIndex));
                bIndex++;
            }
        }
        if (aIndex < A.size()){
            result.addAll(A.subList(aIndex, A.size()));
        }
        if (bIndex < B.size()){
            result.addAll(B.subList(bIndex, B.size()));
        }
        return result;
    }

    // MAKELIST: creates a LinkedList out of the list of Buyables returned by the MergeSort method when it sorts the array of Buyables passed in.

    public void makeList(){
        for (int i = 0; i < _items.size(); i++) {
            _itemsList.add(i, this.mergeSort(_items).get(i));
        }
    }

    // gets the LinkedList created in makeList.

    public LinkedList<Buyable> getItemsList(){
        return _itemsList;
    }
}
