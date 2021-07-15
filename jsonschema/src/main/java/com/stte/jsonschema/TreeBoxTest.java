package com.stte.jsonschema;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出结点为isBox为true的结点，包含经过的结点
 *
 * @author: chenxiaohua
 * @date: 2021/7/15
 */
public class TreeBoxTest {

    public static void main(String[] args) throws IOException {
        ClassPathResource json = new ClassPathResource("/tree-box.json");
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(new Type[]{TreeBox.class}, List.class, List.class);
        List<TreeBox> tree = JSON.parseObject(json.getInputStream(), parameterizedType);
        System.out.println(tree);

        LinkedList<Integer> boxedList = new LinkedList<>();
        lisIsBox(tree, boxedList);
        System.out.println(boxedList);
    }

    private static void lisIsBox(List<TreeBox> tree, LinkedList<Integer> boxedList) {
        for (TreeBox treeBox : tree) {
            boxedList.addLast(treeBox.getId());
            List<TreeBox> children = treeBox.getChildren();
            // 叶子节点，isBox为false，移除
            if (children == null || children.isEmpty()) {
                if (!treeBox.isBox) {
                    boxedList.removeLast();
                }
            } else {
                lisIsBox(children, boxedList);
            }
            // 最后一个结点为当前结点且isBox为false是，说明其子结点中没有isBox为true的结点
            if (treeBox.getId() == boxedList.getLast() && !treeBox.isBox) {
                boxedList.removeLast();
            }
        }
    }

    private static class TreeBox {
        private int id;
        private String name;
        private boolean isBox;
        private List<TreeBox> children;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isBox() {
            return isBox;
        }

        public void setBox(boolean box) {
            isBox = box;
        }

        public List<TreeBox> getChildren() {
            return children;
        }

        public void setChildren(List<TreeBox> children) {
            this.children = children;
        }
    }

}
