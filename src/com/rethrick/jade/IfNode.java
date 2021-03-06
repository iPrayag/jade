package com.rethrick.jade;

import java.util.Map;

/**
 * @author dhanji@gmail.com (Dhanji R. Prasanna)
 */
class IfNode extends Node {
  private String ifExpression;

  IfNode(JadeOptions options) {super(options);}

  @Override public void setTemplate(int indent, String line) {
    super.setTemplate(indent, line);

    ifExpression = line.startsWith("if ")
        ? line.substring("if ".length())
        : line.substring("- if ".length());
  }

  @Override public void emit(StringBuilder out, Map<String, Object> context) {
    out.append("@if{").append(ifExpression).append("}");
      for (Node child : getChildren()) {
        child.emit(out, context);
      }
    out.append("@end{}");
  }
}
