package ru.job4j.collection;
import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> temp = findBy(parent);
        if (temp.isPresent()) {
            Optional<Node<E>> tempChild = findBy(child);
            if(tempChild.isEmpty()){
                temp.get().children.add(new Node<>(child));
                return true;
            }
        }
        return rsl;
    }

/*    private boolean recursive(List<Node<E>> nodes) {
        if(nodes.size() > 2) {
            return false;
        }
        for (Node<E> val : nodes) {
            return recursive(val.children);
        }
        return true;
    }*/

    public Optional<Node<E>> find(Node<E> root, Predicate<Node<E>> val){
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (val.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }


    public boolean isBinary() {
        Optional<Node<E>> re = find(this.root, el -> el.children.size()>2);
        if(re.isEmpty()){
            return true;
        }
        return false;
    }


    @Override
    public Optional<Node<E>> findBy(E value) {
        return find(this.root, el -> el.value.equals(value));
      /*  Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;*/
    }
}