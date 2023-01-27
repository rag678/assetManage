package com.example.assetManage.controllers;

import com.example.assetManage.entities.Assets;
import com.example.assetManage.entities.Employee;
import com.example.assetManage.exception.ResourceNotFoundException;
import com.example.assetManage.repository.AssetRepository;
import com.example.assetManage.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AssetController {
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/assets")
    public List<Assets> getAllAssets(){
        return this.assetRepository.findAll();
    }
    @GetMapping("/assets/{id}")
    public ResponseEntity<Assets> getAssetById(@PathVariable(value = "id") Long assetId)
    throws ResourceNotFoundException {
        Assets assets = assetRepository.findById(assetId)
                .orElseThrow(()-> new ResourceNotFoundException("Assets Not Found For This id ::" + assetId ));
        return ResponseEntity.ok().body(assets);
    }
    @PostMapping("/assets")
    public Assets createAsset(@RequestBody Assets assets){
        return this.assetRepository.save(assets);
    }
    // update the employee
    @PutMapping("/asset/{id}")
    public ResponseEntity<Assets> updateEmployee(@PathVariable(value = "id") Long assetId,
                                                   @RequestBody Assets assetDetails) throws ResourceNotFoundException {
        Assets assets = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Assets not found for this id :: " + assetId));
        assets.setC_id(assetDetails.getC_id());
        assets.setName(assetDetails.getName());
        assets.setS_id(assetDetails.getS_id());
        final Assets updatedAsset = assetRepository.save(assets);
        return ResponseEntity.ok(updatedAsset);
    }
//   retriev asset from employee
    @PutMapping("assets/{id}")
    public ResponseEntity<Assets> updateAsset(@PathVariable(value = "id") Long assetId) throws ResourceNotFoundException {
        Assets assets = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Assets not found for this id :: " + assetId));
        Employee employee = employeeRepository.findById(assets.getC_id())
                .orElseThrow(() -> new ResourceNotFoundException("Assets not found for this id :: " + assetId));
        employee.setAssetId(null);
        assets.setS_id(0);
        final Assets updatedAsset = assetRepository.save(assets);
        return ResponseEntity.ok(updatedAsset);
    }
    @DeleteMapping("/assets/{id}")
    public Map<String, Boolean> deleteAsset(@PathVariable(value = "id") Long assetId)
            throws ResourceNotFoundException {
        Assets asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + assetId));
        if(asset.getS_id() == 0) {
            assetRepository.delete(asset);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
        else{
            throw new ResourceNotFoundException("Asset is assigned to " + asset.getC_id());
        }
    }
    @GetMapping("/assets/name/{name}")
    public ResponseEntity<Assets> getAssetByName(@PathVariable(value = "name") String assetName)
            throws ResourceNotFoundException {
        Assets assets = assetRepository.findByName(assetName)
                .orElseThrow(()-> new ResourceNotFoundException("Assets Not Found For This id ::" + assetName ));
        return ResponseEntity.ok().body(assets);
    }

}
