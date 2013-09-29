package view.cells;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class HoverListCellRenderer extends DefaultListCellRenderer {  

	private static final long serialVersionUID = 9037091771053473873L;
	private static final Color HOVER_COLOR = new Color(208,233,253);
	private int hoverIndex = -1;
	private MouseAdapter handler;
	private JList<? extends CellListCaracs> list;

	public HoverListCellRenderer(JList<? extends CellListCaracs> list) {
		super();
		this.list = list;
	}

	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {  
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);  

		CellListCaracs thisvalue = (CellListCaracs) value;
		thisvalue.setPreferredSize(new Dimension(thisvalue.getWidth(),thisvalue.getHeight()));
		thisvalue.setMinimumSize(thisvalue.getPreferredSize());
		thisvalue.setMaximumSize(thisvalue.getPreferredSize());

		if (!isSelected) {  
			thisvalue.setBackground(index == hoverIndex	? HOVER_COLOR : Color.white);  
		}
		else {
			thisvalue.setBackground(new Color(247,212,170));
		}
		return thisvalue;  
	}  

	public MouseAdapter getHandler() {  
		if (handler == null) {  
			handler = new HoverMouseHandler(list);  
		}  
		return handler;  
	}

	public int getHoverIndex() {
		return hoverIndex;
	}

	class HoverMouseHandler extends MouseAdapter {  

		private final JList<? extends CellListCaracs> flist;

		public HoverMouseHandler(JList<? extends CellListCaracs> list) {  
			this.flist = list;  
		}  

		public void mouseExited(MouseEvent e) {  
			setHoverIndex(-1);  
		}  

		public void mouseMoved(MouseEvent e) {  
			if (flist.getModel().getSize()!=0) {
				int index = flist.locationToIndex(e.getPoint());
				setHoverIndex(flist.getCellBounds(index, index).contains(
						e.getPoint()) ? index : -1);
			}
		}  

		private void setHoverIndex(int index) {  
			if (hoverIndex == index) return;  
			hoverIndex = index;  
			flist.repaint();  
		}  
	}  
}