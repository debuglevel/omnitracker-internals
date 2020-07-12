package de.debuglevel.omnitrackerinternals.diagram.formats

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import mu.KotlinLogging

class YedVisualizationWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    private val logger = KotlinLogging.logger {}

    private val nodePrefix = "node"
    private val edgePrefix = "edge"

    override fun generate(): String {
        logger.debug { "Generating yEd GraphML..." }

        var dot = """
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<graphml xmlns="http://graphml.graphdrawing.org/xmlns" xmlns:java="http://www.yworks.com/xml/yfiles-common/1.0/java" xmlns:sys="http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0" xmlns:x="http://www.yworks.com/xml/yfiles-common/markup/2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:y="http://www.yworks.com/xml/graphml" xmlns:yed="http://www.yworks.com/xml/yed/3" xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd">
  <!--Created by yEd 3.18.1.1-->
  <key attr.name="Beschreibung" attr.type="string" for="graph" id="d0"/>
  <key for="port" id="d1" yfiles.type="portgraphics"/>
  <key for="port" id="d2" yfiles.type="portgeometry"/>
  <key for="port" id="d3" yfiles.type="portuserdata"/>
  <key attr.name="url" attr.type="string" for="node" id="d4"/>
  <key attr.name="description" attr.type="string" for="node" id="d5"/>
  <key for="node" id="d6" yfiles.type="nodegraphics"/>
  <key for="graphml" id="d7" yfiles.type="resources"/>
  <key attr.name="url" attr.type="string" for="edge" id="d8"/>
  <key attr.name="description" attr.type="string" for="edge" id="d9"/>
  <key for="edge" id="d10" yfiles.type="edgegraphics"/>
  <graph edgedefault="directed" id="G">
    <data key="d0"/>
        """.trimIndent()

        dot += entities.joinToString(separator = "\n\n") { generate(it) }
        dot += relationships.joinToString(separator = "\n") { generate(it) }

        dot += """ 
              </graph>
              <data key="d7">
                <y:Resources/>
              </data>
            </graphml>
        """.trimIndent()

        logger.debug { "Generated yEd GraphML" }
        logger.trace { "Generated yEd GraphML: $dot" }
        return dot
    }

    private fun generate(entity: Entity): String {
        logger.debug { "Creating yEd GraphML description of entity $entity..." }

        val nodeId = nodePrefix + entity.hashCode()
        val nodeLabel = escapeHTML(entity.name)

        val output = """
                <node id="$nodeId">
                  <data key="d5"/>
                  <data key="d6">
                    <y:ShapeNode>
                      <y:Geometry height="30.0" width="64.671875" x="433.6640625" y="448.0"/>
                      <y:Fill color="#FFCC00" transparent="false"/>
                      <y:BorderStyle color="#000000" raised="false" type="line" width="1.0"/>
                      <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" hasLineColor="false" height="18.701171875" horizontalTextPosition="center" iconTextGap="4" modelName="custom" textColor="#000000" verticalTextPosition="bottom" visible="true" width="54.671875" x="5.0" y="5.6494140625">$nodeLabel<y:LabelModel>
                          <y:SmartNodeLabelModel distance="4.0"/>
                        </y:LabelModel>
                        <y:ModelParameter>
                          <y:SmartNodeLabelModelParameter labelRatioX="0.0" labelRatioY="0.0" nodeRatioX="0.0" nodeRatioY="0.0" offsetX="0.0" offsetY="0.0" upX="0.0" upY="-1.0"/>
                        </y:ModelParameter>
                      </y:NodeLabel>
                      <y:Shape type="rectangle"/>
                    </y:ShapeNode>
                  </data>
                </node>
        """.trimIndent()

        return output
    }

    private fun generate(attribute: Attribute): String {
        logger.debug { "Creating yEd GraphML description of attribute $attribute..." }

        val output = attribute.name
        return output
    }

    private fun generate(relationship: Relationship): String {
        logger.debug { "Creating yEd GraphML description of relationship $relationship..." }

        val edgeId = edgePrefix + relationship.hashCode()
        val sourceId = nodePrefix + relationship.left.hashCode()
        val targetId = nodePrefix + relationship.right.hashCode()

        val output = """
                            <edge id="$edgeId" source="$sourceId" target="$targetId">
                              <data key="d9"/>
                              <data key="d10">
                                <y:PolyLineEdge>
                                  <y:Path sx="0.0" sy="0.0" tx="0.0" ty="0.0"/>
                                  <y:LineStyle color="#000000" type="line" width="1.0"/>
                                  <y:Arrows source="none" target="standard"/>
                                  <y:BendStyle smoothed="false"/>
                                </y:PolyLineEdge>
                              </data>
                            </edge>
        """.trimIndent()

        return output

//        var output = ""
//        output += "${relationship.left.name}"
//
//        output += when (relationship.rightHasThatManyLefts) {
//            Cardinality.One -> "\"1\""
//            Cardinality.OneOrMore -> "\"1+\""
//            Cardinality.ZeroOrOne -> "\"0,1\""
//            Cardinality.ZeroOrMore -> "\"0+\""
//        }
//        output += " *-- "
//        output += when (relationship.leftHasThatManyRights) {
//            Cardinality.One -> "\"1\""
//            Cardinality.OneOrMore -> "\"1+\""
//            Cardinality.ZeroOrOne -> "\"0,1\""
//            Cardinality.ZeroOrMore -> "\"0+\""
//        }
//        output += "${relationship.right.name}"
//        output += if (relationship.label != null) " : ${relationship.label}" else ""
//
//        return output
    }

    // see: https://stackoverflow.com/a/25228492/4764279
    private fun escapeHTML(s: String): String? {
        val out = StringBuilder(Math.max(16, s.length))
        for (i in 0 until s.length) {
            val c = s[i]
            if (c.toInt() > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
                out.append("&#")
                out.append(c.toInt())
                out.append(';')
            } else {
                out.append(c)
            }
        }
        return out.toString()
    }
}