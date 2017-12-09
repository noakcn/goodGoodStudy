package com.cxd.sotiy.handler.node;

import com.cxd.sotiy.constants.AttributeConstant;
import com.cxd.sotiy.constants.NodeConstant;
import com.cxd.sotiy.node.AbstractNode;
import com.cxd.sotiy.node.FromNode;
import com.cxd.sotiy.statement.AbstractStatement;
import com.google.common.base.CharMatcher;
import org.dom4j.Element;

/**
 * desc
 *
 * @author childe
 * @date 2017/12/4 19:52
 **/
public class FromHandler implements INodeHandler {
    @Override
    public Element doHandle(Element element, AbstractStatement statement) {
        Element fromEle = element.element(NodeConstant.FROM);

        AbstractNode fromNode = new FromNode();

        if (fromEle == null) {
            statement.setField(fromNode.getPretreatmentBuffer().toString());
            return element;
        }

        fromNode.setTrim(Boolean.valueOf(fromEle.attributeValue(AttributeConstant.TRIM,"true")));
        fromNode.setPreCondition(CharMatcher.WHITESPACE.removeFrom(fromEle.getText()));

        statement.setCollection(fromNode.getPretreatmentBuffer().toString());

        return element;
    }
}
