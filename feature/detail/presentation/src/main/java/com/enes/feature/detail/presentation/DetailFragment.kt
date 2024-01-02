package com.enes.feature.detail.presentation

import android.widget.LinearLayout
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.enes.common.presentation.BaseFragment
import com.enes.common.presentation.utils.fragmentViewBinding
import com.enes.feature.detail.domain.entity.GetCharacterDetailResponseModelEntity
import com.enes.feature.detail.presentation.component.PairView
import com.enes.feature.detail.presentation.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment(R.layout.fragment_detail) {
    override val binding by fragmentViewBinding(FragmentDetailBinding::bind)
    override val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun bindUI() {
        super.bindUI()
    }

    override fun bindViewModel() {
        super.bindViewModel()
        viewModel.getCharacterDetail(id = args.id)

        viewModel.characterDetail.observe(viewLifecycleOwner) {
            binding.imageProfile.load(it.image)
            binding.progressCircular.isGone = true
            binding.createdDate.text = it.created
            informationTable(it)
            locationTable(it)
        }
    }

    private fun prepareTextView(pair: Pair<String, String>): PairView {
        val pairView = PairView(binding.root.context)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        pairView.layoutParams = params
        pairView.setUp(pair.first, pair.second)

        return pairView
    }

    private fun informationTable(model: GetCharacterDetailResponseModelEntity) {
        binding.gridLayoutPersonalInfo.apply {
            addView(
                prepareTextView(
                    Pair("Name", model.name)
                )
            )
            addView(
                prepareTextView(
                    Pair("Status", model.status)
                )
            )
            addView(
                prepareTextView(
                    Pair("Species", model.species)
                )
            )
            addView(
                prepareTextView(
                    Pair("Gender", model.gender)
                )
            )
        }
    }

    private fun locationTable(model: GetCharacterDetailResponseModelEntity) {
        binding.gridLayoutLocation.apply {
            addView(
                prepareTextView(
                    Pair("Name", model.location.name)
                )
            )
            addView(
                prepareTextView(
                    Pair("URL", model.location.url)
                )
            )
        }
    }

}