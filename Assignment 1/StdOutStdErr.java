/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asmt01ec;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Mark
 */
/**
 *
 * @author Duc Ta PLUS
 */
public class StdOutStdErr extends OutputStream {

    OutputStream[] outputStreams;

    public StdOutStdErr(OutputStream... outputStreams) {
        this.outputStreams = outputStreams;
    }

    @Override
    public void write(int b) throws IOException {
        for (OutputStream out : outputStreams) {
            out.write(b);
        }
    }

    @Override
    public void write(byte[] b) throws IOException {
        for (OutputStream out : outputStreams) {
            out.write(b);
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (OutputStream out : outputStreams) {
            out.write(b, off, len);
        }
    }

    @Override
    public void flush() throws IOException {
        for (OutputStream out : outputStreams) {
            out.flush();
        }
    }

    @Override
    public void close() throws IOException {
        for (OutputStream out : outputStreams) {
            out.close();
        }
    }
}