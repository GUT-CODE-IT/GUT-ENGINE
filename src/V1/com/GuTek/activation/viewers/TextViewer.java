/*
    Author: .GuTeK <dev@gutcode.pl>
    Project: GUT-ENGINE [MINECRAFT ENGINE]
    Price: WEBSITE
    Resources: 11/6780
    Data: 29.02.2024
    Contact Discord: .GuTeK#0001
    Contact e-mail: dev@gutcode.pl
    Our websites: https://gutcode.pl
    ⓒ 2024 by .GuTeK | ALL RIGHTS RESERVED |
*/

package V1.com.GuTek.activation.viewers;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TextViewer  extends Panel implements CommandObject {
    private TextArea text_area;
    private File text_file;
    private String text_buffer;
    private DataHandler _dh;
    private boolean DEBUG;

    public TextViewer() {
        this.text_area = null;
        this.text_file = null;
        this.text_buffer = null;
        this._dh = null;
        this.DEBUG = false;
        this.setLayout(new GridLayout(rows:1, cols:1));
        (this.text_area = new TextArea(text: "", rows:24, columns: 80, scrollbars:1)).setEdititable(b:false);
        this.add(this.text_area);
    }

    public void setCommandContext(final String verb, final DataHandler dh) throws IOException {
        this._dh = dh;
        this.setInputStream(this._dh.getInputStream());
    }

    public void setInputStream(final InputStream ins) throws IOException {
        int bytes_read = 0;
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final byte[] data = new byte[1024];
        while ((bytes_read = ins.read(data)) > 0) {
            baos.write(data, off:0, bytes_read);
        }
        ins.close();
        this.text_buffer = baos.toString();
        this.text_area.setText(this.text_buffer);
    }

    public void addNotify() {
        super.addNotify();
        this.invalidate();
    }

    public Dimension getPrefferedSize() {
        return this.text_area.getMinimumSize(rows:24, columns:80);
    }
}
