/*
 * Copyright (C) 2018 - 2019 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uw.cs.seaglass.app.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CellObservationDAO {
    @Insert
    void insert(CellObservation observation);

    @Query("SELECT * FROM CellObservation WHERE synced IS 0 LIMIT :limit")
    List<CellObservation> getUnsynced(int limit);

    @Query("UPDATE CellObservation SET synced = 1 WHERE id IN (:ids)")
    void markSynced(List<Integer> ids);

    @Query("UPDATE CellObservation SET synced = 1 WHERE id = :id")
    void markSynced(int id);
}
