package co.com.clinicaKarol.Datos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomTableModel extends AbstractTableModel {
    private List<String> data;
    private int rowsPerPage;
    private int currentPage;

    public CustomTableModel(List<String> data, int rowsPerPage) {
        this.data = data;
        this.rowsPerPage = rowsPerPage;
        this.currentPage = 0;
    }

    @Override
    public int getRowCount() {
        int startIndex = currentPage * rowsPerPage;
        return Math.min(rowsPerPage, data.size() - startIndex);
    }

    @Override
    public int getColumnCount() {
        return 1; // Solo una columna para los textos
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int startIndex = currentPage * rowsPerPage;
        int dataIndex = startIndex + rowIndex;
        return data.get(dataIndex);
    }

    // Método para cambiar a la página anterior
    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            fireTableDataChanged();
        }
    }

    // Método para cambiar a la página siguiente
    public void nextPage() {
        int maxPages = data.size() / rowsPerPage;
        if (currentPage < maxPages) {
            currentPage++;
            fireTableDataChanged();
        }
    }

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


}
