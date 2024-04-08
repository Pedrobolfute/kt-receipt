package presentation

import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.*

class HomeFrame : JFrame() {
    private val componentWidth = 200
    init {
        layout = BorderLayout()
        // specify frame size
        size = Dimension(700, 150)
        add(JPanel().apply {
            //our side pane
            layout = FlowLayout(FlowLayout.LEFT, 0, 2)
            background = this.background.brighter()
            preferredSize = Dimension(componentWidth, 0)
            add(JPanel().apply {
                background = Color.GRAY
                preferredSize = Dimension(componentWidth, 50)
                add(JLabel("Welcome"))
            })

            //add buttons
            add(customButton("Button 1").apply {
                //example action
                addActionListener{
                    println("Button 1 Clicked")
                }
            })
            add(customButton("Button 2"))
            add(customButton("Button 3"))
            add(customButton("Button 4"))
            add(customButton("Button 5"))
            add(Box.createVerticalGlue())

        }, BorderLayout.WEST)
    }

    private fun customButton(text: String) : JButton {
        return JButton(text).apply {
            background = background.darker()
            preferredSize = Dimension(componentWidth, 28)
            isBorderPainted = false
            isFocusPainted = false
        }
    }
}