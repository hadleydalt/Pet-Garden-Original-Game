package indy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sorts {
    private LinkedList<Buyable> _itemsList;
    private ArrayList<Buyable> _items;
    public Sorts(ArrayList<Buyable> items){
        _items = items;
        _itemsList = new LinkedList<Buyable>();
    }

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

    /*public List<Integer> mergeSort(List<Integer> list) {
            if (list.size() == 1) {
                return list;
            }
            int middle = list.size() / 2;
            List<Integer> left =
                    this.mergeSort(list.subList(0, middle));
            List<Integer> right =
                    this.mergeSort(list.subList(middle, list.size()));

            return this.merge(left, right);
        }

    public ArrayList<Integer> merge(List<Integer> A, List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int aIndex = 0;
        int bIndex = 0;
        while ((aIndex < A.size()) && (bIndex < B.size())){
            if (A.get(aIndex) <= B.get(bIndex)){
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
    } */

    public void makeList(){
        for (int i = 0; i < _items.size(); i++) {
            _itemsList.add(i, this.mergeSort(_items).get(i));
        }
    }

    public LinkedList<Buyable> getItemsList(){
        return _itemsList;
    }
}
