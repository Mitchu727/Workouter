import androidx.lifecycle.ViewModel
import com.example.workouter.model.service.StorageService

class StatsViewModel(
    private val storageService: StorageService
): ViewModel() {
    val trainingParts = storageService.trainingParts
}