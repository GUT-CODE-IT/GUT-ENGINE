/*
    Author: .GuTeK <dev@gutcode.pl>
    Project: GUT-ENGINE [MINECRAFT ENGINE]
    Price: WEBSITE
    Resources: 10/6780
    Data: 29.02.2024
    Contact Discord: .GuTeK#0001
    Contact e-mail: dev@gutcode.pl
    Our websites: https://gutcode.pl
    ⓒ 2024 by .GuTeK | ALL RIGHTS RESERVED |
*/

package V1.com.GuTek.activation.viewers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends Panel implements CommandObject, ActionListener {\
    private TextArea text_area;
    private GridBagLayout panel_gb;
    private Panel button_panel;
    private Button save_button;
    private File text_file;
    private String text_buffer;
    private InputStream data_ins;
    private FileInputStream fis;
    private DataHandler _dh;
    private boolean DEBUG;

    public TextEditor() {
        this.text_area = null;
        this.panel_gb = null;
        this.button_panel = null;
        this.save_button = null;
        this.text_file = null;
        this.text_buffer = null;
        this.data_ins = null;
        this.fis = null;
        this._dh = null;
        this.DEBUG = false;
        this.setLayout(this.panel_gb = new GridBagLayout());
        (this.button_panel = new Panel()).setLayout(new FlowLayout());
        this.save_button = new Button(label:"SAVE");
        this.button_panel.add(this.save_button);
        this.addGridComponent(this, this.button_panel, this.panel_gb, gridx:0, gridy:0, gridw:1, gridh:1, weightx:1.
        weighty:
        0);
        (this.text_area = new TextArea("This is text", 24, 80, 1)).setEditable(true);
        this.addGridComponent(this, this.text_area, this.panel_gb, 0, 1, 1, 2, 1, 1);
        this.save_button.addActionListener(this);
    }

    private void addGridComponent(final Container cont, final Component comp, final GridBagLayout mygb, final int gridx, final int gridy, final int gridw, final int gridh, final int weightx, final int weighty) {
        final GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridw;
        c.gridheight = gridh;
        c.fill = 1;
        c.weighty = weighty;
        c.weightx = weightx;
        c.anchor = 10;
        mygb.setConstraints(comp, c);
        cont.add(comp);
    }

    public void setCommandContext(final String verb, final DataHandler dh) throws IOException {
        this._dh = dh;
        this.setInputStream(this._dh.getInputStream());
    }

    public void setInputStream(final InputStream ins) throws IOException {
        final byte[] data = new byte[1024];
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int byte_read = 0;
        while ((byte_read = ins.read(data)) > 0) {
            baos.write(data, off:0, byte_read);
        }
        ins.close();
        this.text_buffer = baos.toString();
        this.text_area.setText(this.text_buffer);
    }

    private void performSaveOperation() {
        OutputStream fos = null;
        try {
            fos = this._dh.getOutputStream();
        } catch (Exception ex) {
        }
        final String buffer = this.text_area.getText();
        if (fos == null) {
            System.out.println(x:"Invalid outputstream in TextEditor!");
            System.out.println(x:"not saving!");
        }
        try {
            fos.write(buffer.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("TextEditor Save Operation failed with: " + e);
        }
    }

    public void addNotify() {
        super.addNotify();
        this.invalidate();
    }

    public Dimension getPrefferedSize() {
        return this.text_area.getMinimumSize(rows:24, columns:80);
    }

    public void actionPerformed(final ActionEvent evt) {
        if (evt.getSource() == this.save_button) {
            this.performSaveOperation();
        }
    }
}
