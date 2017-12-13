package net.marco27.aem6.components.osgi.jsonxml.exception;

public class JsonXmlException extends Exception {

    private boolean traceException;

    public JsonXmlException(String message) {
        this(message, true);
    }

    public JsonXmlException(String message, Throwable cause) {
        super(message, cause);
        traceException = traceException(cause);
    }

    public JsonXmlException(Throwable cause) {
        super(cause);
        traceException = traceException(cause);
    }

    public JsonXmlException(Throwable cause, boolean traceException) {
        super(cause);
        this.traceException = traceException;
    }

    public JsonXmlException(String message, boolean traceException) {
        super(message);
        this.traceException = traceException;
    }

    public JsonXmlException(String message, Throwable cause, boolean traceException) {
        super(message, cause);
        this.traceException = traceException;
    }

    private static boolean traceException(Throwable cause) {
        return cause instanceof JsonXmlException ? JsonXmlException.class.cast(cause).isTraceException() : true;
    }

    public boolean isTraceException() {
        return traceException;
    }
}
